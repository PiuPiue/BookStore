package com.briup.bookstore.service;


import com.briup.bookstore.po.OrderItem;

/**
* @author qinyc
* @description 针对表【es_order_item】的数据库操作Service
* @createDate 2023-07-18 21:33:25
*/
public interface OrderItemService {
    public void save(OrderItem orderItem);
}
