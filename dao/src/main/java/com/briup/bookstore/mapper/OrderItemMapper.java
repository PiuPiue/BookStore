package com.briup.bookstore.mapper;

import com.briup.bookstore.po.OrderItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_order_item】的数据库操作Mapper
* @createDate 2023-07-18 21:33:25
* @Entity com.briup.bookstore.po.OrderItem
*/
@Repository
public interface OrderItemMapper {
    void deleteByOrderId(@Param("orderId") String orderId);

    void  save(OrderItem orderItem);

    List<OrderItem> findByOrderId(@Param("orderId") String orderId);

    String selectOrderIdById(Integer id);

    void deleteByBookId(Integer id);
}