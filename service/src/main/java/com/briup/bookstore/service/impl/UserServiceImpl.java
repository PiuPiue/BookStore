package com.briup.bookstore.service.impl;

import com.briup.bookstore.dto.UserLoginDTO;
import com.briup.bookstore.dto.UserMessageUpdateDTO;
import com.briup.bookstore.dto.UserRegisterDTO;
import com.briup.bookstore.dto.UserStatusUpdateDTO;
import com.briup.bookstore.exception.BookStoreException;
import com.briup.bookstore.mapper.*;
import com.briup.bookstore.po.User;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.UserService;
import com.briup.bookstore.utils.BeanCopyUtils;
import com.briup.bookstore.utils.JsonWebTokenUtils;
import com.briup.bookstore.vo.UserInfoVO;
import com.briup.bookstore.vo.UserLoginVO;
import com.briup.bookstore.vo.UserPageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CollectMapper collectMapper;

    @Autowired
    private ShopcarMapper shopcarMapper;

    @Override
    public UserLoginVO login(UserLoginDTO adminLoginDTO, Integer roleId) {
        //判断用户名密码是否为空
        if(adminLoginDTO.getUsername()==null||adminLoginDTO.getPassword()==null){
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_USERNAME_IS_NOT_NULL);
        }
        //拿着用户名和密码去数据库里查询
        User user = userMapper.getUserByUsernameAndPassword(adminLoginDTO.getUsername(), adminLoginDTO.getPassword());
        if(user==null)
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_USERNAME_OR_PASSWORD_ERROR);

        //比较查询出的用户和当前登录的角色是否一致
        if(user.getRoleId()!=roleId){
            throw new BookStoreException(512,"角色错误");
        }
        //签发token
        String jwt = JsonWebTokenUtils.createJWT(user.getId().toString());
        UserLoginVO vo = new UserLoginVO();
        vo.setJwt(jwt);
        UserInfoVO userInfoVO = BeanCopyUtils.copyBean(user, UserInfoVO.class);
        vo.setUserInfo(userInfoVO);
        return vo;
    }

    @Override
    public PageInfo<UserPageVO> getUserPage(Integer pageNum, Integer pageSize, String username, String status, LocalDateTime startTime, LocalDateTime endTime) {
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        //对应查询
        List<User> list = userMapper.getAllUserByUsernameOrStatus0rRegisterTime(username, status, startTime, endTime);
        List<UserPageVO> userPageVOS = BeanCopyUtils.copyBeanList(list, UserPageVO.class);
        PageInfo<UserPageVO> pageInfo = new PageInfo<UserPageVO>(userPageVOS);
        return pageInfo;
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        //检验用户名和密码是否为空
        if(userRegisterDTO.getUsername()==null||userRegisterDTO.getPassword()==null){
            throw new BookStoreException(BookStoreException.CodeMsgEnum.USER_USERNAME_IS_NOT_NULL);
        }
        //检查该用户名是否在数据库当中存在
        int count = userMapper.getCountByUsername(userRegisterDTO.getUsername());
        if(count>0){
            throw  new BookStoreException(BookStoreException.CodeMsgEnum.USER_USERNAME_IS_EXIST);
        }
        //注册
        //将userRegisterDto 复制成  User
        User user = BeanCopyUtils.copyBean(userRegisterDTO, User.class);
        userMapper.insertUser(user);
    }

    @Override
    public void updateUserStatus(UserStatusUpdateDTO userStatusUpdateDTO) {

    }

    @Override
    public void deleteUser(String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            //首先删除用户对应的地址
            addressMapper.deleteByUserId(s);
            //删除对应的购物车
            shopcarMapper.deleteByUserId(s);
            //删除订单
            orderMapper.deleteByUserId(s);
            //删除收藏信息
            collectMapper.deleteByUserId(s);
            //删除该用户
            userMapper.deleteBatchIds(s);
        }
    }

    @Override
    public UserInfoVO getUserInfo(String id) {
        //根据id来查找用户信息
        User user = userMapper.getUserById(Integer.valueOf(id));
        UserInfoVO userInfoVO = BeanCopyUtils.copyBean(user, UserInfoVO.class);
        return userInfoVO;
    }

    @Override
    public UserInfoVO updateUserMessage(UserMessageUpdateDTO userMessageUpdateDTO) {
        System.out.println(userMessageUpdateDTO);
         userMapper.updateUserMessage(userMessageUpdateDTO);
        User user = userMapper.getUserById(userMessageUpdateDTO.getId());
        UserInfoVO userInfoVO = BeanCopyUtils.copyBean(user, UserInfoVO.class);
        System.out.println(userInfoVO);
        return userInfoVO;
    }

    @Override
    public void updatePassword(int parseInt, String oldPassword, String newPassword) {
        User user = userMapper.getUserByUserIdAndPassword(parseInt, oldPassword);
        if (user == null){
            throw new BookStoreException(503,"密码错误");
        }
        userMapper.updateUserPassword(newPassword,parseInt);
    }

}
