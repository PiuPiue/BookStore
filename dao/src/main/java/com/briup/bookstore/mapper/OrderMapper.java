package com.briup.bookstore.mapper;

import com.briup.bookstore.dto.OrderDeliveryDTO;
import com.briup.bookstore.dto.OrderPaySuccessDTO;
import com.briup.bookstore.dto.OrderSearchDTO;
import com.briup.bookstore.po.Order;
import com.briup.bookstore.po.ext.OrderExtend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_order】的数据库操作Mapper
* @createDate 2023-07-18 21:33:14
* @Entity com.briup.bookstore.po.Order
*/
@Repository
public interface OrderMapper {

    List<OrderExtend> selectOrdersByCondition(@Param("orderSearchDTO") OrderSearchDTO orderSearchDTO);

    OrderExtend selectOrderDetailById(@Param("orderId") String orderId);

    Order selectOrderById(@Param("orderId") String orderId);

    void updateStatusToClose(@Param("orderId") String orderId);

    void updateStatusToDelivery(@Param("orderDeliveryDTO") OrderDeliveryDTO orderDeliveryDTO);

    void save(Order order);

    void completeOrder(@Param("orderId") String orderId);

    List<OrderExtend> selectOrderDetailByUserId(@Param("userId") Integer userId,@Param("orderSearchDTO") OrderSearchDTO orderSearchDTO);

    void paySuccess( OrderPaySuccessDTO paySuccessDTO);

    void deleteByUserId(String uid);

    void deleteById(String orderId);
}




