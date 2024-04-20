package com.briup.bookstore.web.controller;

import com.briup.bookstore.annotation.SystemLog;
import com.briup.bookstore.dto.OrderCreateDTO;
import com.briup.bookstore.dto.OrderSearchDTO;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.OrderItemService;
import com.briup.bookstore.service.OrderService;
import com.briup.bookstore.vo.OrderDetailVO;
import com.briup.bookstore.vo.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping()
    @SystemLog(businessName = "创建订单")
    public Result createOrder(@RequestBody OrderCreateDTO orderCreateDTO, HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
        OrderDetailVO order = orderService.createOrder(orderCreateDTO, Integer.parseInt(userId));
        return Result.success(order);
    }

    @GetMapping()
    @SystemLog(businessName = "获取订单")
    public Result getOrders( HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
        List<OrderInfoVO> orders = orderService.getOrders(Integer.parseInt(userId), null);
        return Result.success(orders);
    }

    @PutMapping("/close/{id}")
    @SystemLog(businessName = "取消订单")
    public Result closeOrder(@PathVariable String id){
        orderService.closeOrder(String.valueOf(id));
        return Result.success();
    }

    @GetMapping("/{id}")
    @SystemLog(businessName = "获取详细订单")
    public Result getOrder(@PathVariable String id){
        OrderDetailVO orderById = orderService.getOrderById(id);
        return Result.success(orderById);
    }

}
