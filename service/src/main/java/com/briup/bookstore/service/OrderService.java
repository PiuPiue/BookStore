package com.briup.bookstore.service;

import com.briup.bookstore.dto.OrderCreateDTO;
import com.briup.bookstore.dto.OrderDeliveryDTO;
import com.briup.bookstore.dto.OrderPaySuccessDTO;
import com.briup.bookstore.dto.OrderSearchDTO;
import com.briup.bookstore.vo.OrderDetailVO;
import com.briup.bookstore.vo.OrderInfoVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_order】的数据库操作Service
* @createDate 2023-07-18 21:33:14
*/
public interface OrderService {
    PageInfo<OrderInfoVO> getPageOrder(Integer pageNum, Integer pageSize, OrderSearchDTO orderSearchDTO);

    OrderDetailVO getOrderById(String orderId);

    void closeOrder(String id);

    void delivery(OrderDeliveryDTO orderDeliveryDTO);


    void completeOrder(String orderId);

    List<OrderInfoVO> getOrders(int parseInt,OrderSearchDTO orderSearchDTO);

    OrderDetailVO createOrder(OrderCreateDTO orderCreateDTO, int parseInt);

    void paySuccess(OrderPaySuccessDTO paySuccessDTO);
}