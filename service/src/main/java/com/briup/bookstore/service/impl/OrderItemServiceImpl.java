package com.briup.bookstore.service.impl;

import com.briup.bookstore.mapper.OrderItemMapper;
import com.briup.bookstore.po.OrderItem;
import com.briup.bookstore.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public void save(OrderItem orderItem) {
        orderItemMapper.save(orderItem);
    }
}
