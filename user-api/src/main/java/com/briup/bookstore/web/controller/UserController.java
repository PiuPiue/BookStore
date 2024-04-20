package com.briup.bookstore.web.controller;

import com.briup.bookstore.annotation.SystemLog;
import com.briup.bookstore.dto.UserLoginDTO;
import com.briup.bookstore.dto.UserMessageUpdateDTO;
import com.briup.bookstore.dto.UserRegisterDTO;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.UserService;
import com.briup.bookstore.vo.UserInfoVO;
import com.briup.bookstore.vo.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody UserRegisterDTO userRegisterDTO){
        //引入对应业务层
        userService.register(userRegisterDTO);
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserLoginDTO dto){
        UserLoginVO user = userService.login(dto, 2);
        return Result.success(user);
    }

    @GetMapping("/getUserInfo")
    @SystemLog(businessName = "获取")
    public Result getUserInfo(HttpServletRequest request){
        String userId = (String)request.getAttribute("userId");
        UserInfoVO userLoginVO = userService.getUserInfo(userId);
        return Result.success(userLoginVO);
    }

    @PutMapping("/updateUser")
    @SystemLog(businessName = "修改用户")
    public Result updateUser(UserMessageUpdateDTO userMessageUpdateDTO){
        UserInfoVO userInfoVO = userService.updateUserMessage(userMessageUpdateDTO);
        return Result.success(userInfoVO);
    }

    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody String oldPassword, @RequestBody String newPassword,HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("userId");
        userService.updatePassword(userId,oldPassword,newPassword);
        return Result.success();
    }


}
