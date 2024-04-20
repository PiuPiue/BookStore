package com.briup.bookstore.service.impl;

import com.briup.bookstore.mapper.ShopcarMapper;
import com.briup.bookstore.po.Shopcar;
import com.briup.bookstore.po.ext.ShopCarExtend;
import com.briup.bookstore.service.ShopCarService;
import com.briup.bookstore.utils.BeanCopyUtils;
import com.briup.bookstore.vo.ShopCarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopCarServiceImpl implements ShopCarService {

    @Autowired
    private ShopcarMapper shopcarMapper;

    @Override
    public List<ShopCarVO> findLists(Integer userId) {
        List<ShopCarExtend> byUserId = shopcarMapper.findByUserId(userId);
        List<ShopCarVO> list = new ArrayList<>();
        for(ShopCarExtend shopCarExtend:byUserId){
            ShopCarVO shopCarVO = BeanCopyUtils.copyBean(shopCarExtend, ShopCarVO.class);
            list.add(shopCarVO);
        }
        return list;
    }

    @Override
    public void add(int userId, Integer bookId) {
        //原本表中没有这条数据
        Shopcar byUserIdAndBookId = shopcarMapper.findByUserIdAndBookId(userId, bookId);
        //则更新一条记录，且数量为1
        //如果有则在原来的基础上+1
        if(byUserIdAndBookId==null){
            shopcarMapper.save(userId,bookId);
        }else {
            shopcarMapper.updateNumById(byUserIdAndBookId.getNum()+1, byUserIdAndBookId.getId());
        }

    }

    @Override
    public void updateNum(Integer id, Integer num) {
        shopcarMapper.updateNumById(num,id);
    }

    @Override
    public void deleteByIds(Integer... ids) {
        for (Integer id : ids) {
            shopcarMapper.deleteById(id);
        }
    }
}
