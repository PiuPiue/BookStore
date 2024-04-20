package com.briup.bookstore.web.controller;

import com.briup.bookstore.annotation.SystemLog;
import com.briup.bookstore.dto.UserLoginDTO;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.UserService;
import com.briup.bookstore.utils.UploadOSSUtils;
import com.briup.bookstore.vo.UserInfoVO;
import com.briup.bookstore.vo.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
//第一次改变
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private UploadOSSUtils utils;

    @PostMapping("/login")
    //@SystemLog(businessName = "管理员登录")
    public Result login(@RequestBody UserLoginDTO dto){
        UserLoginVO user = userService.login(dto, 1);
        return Result.success(user);
    }

    @PostMapping("/upload")
    @SystemLog(businessName = "上传图片")
    public Result upload(@RequestPart MultipartFile img){
        String s = utils.uploadOss(img, img.getName()+ UUID.randomUUID());
        return Result.success(s);
    }

}
