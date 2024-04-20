package com.briup.bookstore.web.controller;

import com.briup.bookstore.annotation.SystemLog;
import com.briup.bookstore.dto.UserMessageUpdateDTO;
import com.briup.bookstore.dto.UserRegisterDTO;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.UserService;
import com.briup.bookstore.vo.UserInfoVO;
import com.briup.bookstore.vo.UserPageVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getUserInfo")
    @SystemLog(businessName = "获取用户信息")
    public Result getUserInfo(HttpServletRequest request){
        String userId = (String)request.getAttribute("userId");
        UserInfoVO userLoginVO = userService.getUserInfo(userId);
        return Result.success(userLoginVO);
    }

    @GetMapping("/getPageUser")
    @SystemLog(businessName = "获取用户信息")
    public Result getPageUser(Integer pageNum, Integer pageSize, String username, String status, String startTime, String endTime){
        LocalDateTime registerStartTime = null;
        LocalDateTime registerEndTime = null;
        if(StringUtils.hasText(startTime)){
            Instant instant = Instant.parse(startTime);
            registerStartTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        }
        if(StringUtils.hasText(endTime)){
            Instant instant = Instant.parse(endTime);
            registerEndTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        }
        PageInfo<UserPageVO> userPage = userService.getUserPage(pageNum, pageSize, username, status, registerStartTime, registerEndTime);
        return Result.success(userPage);
    }

    @GetMapping("/getUserInfoById/{id}")
    @SystemLog(businessName = "获取用户信息")
    public Result getUserInfoById(@PathVariable Integer id){
        UserInfoVO userInfo = userService.getUserInfo(String.valueOf(id));
        return Result.success(userInfo);
    }

    @PutMapping("/updateUserInfo")
    @SystemLog(businessName = "更新用户")
    public Result updateUserInfo(@RequestBody  UserMessageUpdateDTO userMessageUpdateDTO){
        UserInfoVO userInfoVO = userService.updateUserMessage(userMessageUpdateDTO);
        return Result.success(userInfoVO);
    }

    @PostMapping("/addUser")
    @SystemLog(businessName = "添加用户")
    public Result addUser(@RequestBody UserRegisterDTO userRegisterDTO){
        userService.register(userRegisterDTO);
        return Result.success();
    }
    @DeleteMapping("/deleteUser/{id}")
    @SystemLog(businessName = "删除用户")
    public Result deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return Result.success();
    }
}
