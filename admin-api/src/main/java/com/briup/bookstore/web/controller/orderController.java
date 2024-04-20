package com.briup.bookstore.web.controller;

import com.briup.bookstore.dto.OrderSearchDTO;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.OrderService;
import com.briup.bookstore.vo.OrderDetailVO;
import com.briup.bookstore.vo.OrderInfoVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class orderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{pageNum}/{pageSize}")
    public Result getPageOrder(@PathVariable Integer pageNum,@PathVariable Integer pageSize, OrderSearchDTO orderSearchDTO){
        PageInfo<OrderInfoVO> pageOrder = orderService.getPageOrder(pageNum, pageSize, orderSearchDTO);
        return Result.success(pageOrder);
    }

    @GetMapping("/{id}")
    public Result getContentDetails(@PathVariable String id){
        OrderDetailVO orderById = orderService.getOrderById(id);
        return Result.success(orderById);
    }

    @PutMapping("/close/{id}")
    public Result closeOrder(@PathVariable String id){
        orderService.closeOrder(id);
        return Result.success();
    }

}
