package com.briup.bookstore.web.controller;


import com.briup.bookstore.annotation.SystemLog;
import com.briup.bookstore.dto.AddressAddDTO;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("")
    @SystemLog(businessName = "查找用户地址")
    public Result findAddress(HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
        return Result.success(addressService.findAddresses(Integer.valueOf(userId)));
    }

    @PostMapping("")
    @SystemLog(businessName = "新增地址")
    public Result addAddress(AddressAddDTO addressAddDTO){
        addressService.save(addressAddDTO);
        return Result.success();
    }
}
