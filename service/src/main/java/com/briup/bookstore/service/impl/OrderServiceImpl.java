package com.briup.bookstore.service.impl;

import com.briup.bookstore.dto.OrderCreateDTO;
import com.briup.bookstore.dto.OrderDeliveryDTO;
import com.briup.bookstore.dto.OrderPaySuccessDTO;
import com.briup.bookstore.dto.OrderSearchDTO;
import com.briup.bookstore.mapper.CollectMapper;
import com.briup.bookstore.mapper.OrderItemMapper;
import com.briup.bookstore.mapper.OrderMapper;
import com.briup.bookstore.mapper.ShopcarMapper;
import com.briup.bookstore.po.Collect;
import com.briup.bookstore.po.Order;
import com.briup.bookstore.po.OrderItem;
import com.briup.bookstore.po.Shopcar;
import com.briup.bookstore.po.ext.CollectExtend;
import com.briup.bookstore.po.ext.OrderExtend;
import com.briup.bookstore.po.ext.OrderItemExtend;
import com.briup.bookstore.service.OrderService;
import com.briup.bookstore.utils.BeanCopyUtils;
import com.briup.bookstore.vo.OrderDetailVO;
import com.briup.bookstore.vo.OrderInfoVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private ShopcarMapper shopcarMapper;

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public PageInfo<OrderInfoVO> getPageOrder(Integer pageNum, Integer pageSize, OrderSearchDTO orderSearchDTO) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderExtend> orderExtends = orderMapper.selectOrdersByCondition(orderSearchDTO);
        for (OrderExtend orderExtend : orderExtends) {
            orderExtend.genPrice();
        }
        List<OrderInfoVO> orderInfoVOS = BeanCopyUtils.copyBeanList(orderExtends, OrderInfoVO.class);
        PageInfo<OrderInfoVO> orderExtendPageInfo = new PageInfo<>(orderInfoVOS);
        return orderExtendPageInfo;
    }


    @Override
    public OrderDetailVO getOrderById(String orderId) {
        OrderExtend orderExtend = orderMapper.selectOrderDetailById(orderId);
        OrderDetailVO orderDetailVO = BeanCopyUtils.copyBean(orderExtend, OrderDetailVO.class);
        return orderDetailVO;
    }

    @Override
    public void closeOrder(String id) {
        orderItemMapper.deleteByOrderId(id);
    }

    @Override
    public void delivery(OrderDeliveryDTO orderDeliveryDTO) {

    }

    @Override
    public void completeOrder(String orderId) {

    }

    @Override
    public List<OrderInfoVO> getOrders(int parseInt, OrderSearchDTO orderSearchDTO) {
        List<OrderExtend> orderExtends =
                orderMapper.selectOrderDetailByUserId
                        (parseInt, orderSearchDTO);

        for (OrderExtend orderExtend : orderExtends) {
            orderExtend.genPrice();
        }

        List<OrderInfoVO> orderInfoVOS =
                BeanCopyUtils.copyBeanList
                        (orderExtends, OrderInfoVO.class);

        return orderInfoVOS;
    }


    @Override
    public OrderDetailVO createOrder(OrderCreateDTO orderCreateDTO, int parseInt) {
        // 第一步：创建订单项
        Order order = BeanCopyUtils.copyBean(orderCreateDTO, Order.class);
        order.setUserId(parseInt);
        orderMapper.save(order);
        for (Integer shopCarId : orderCreateDTO.getShopCarIds()) {
            Shopcar car = shopcarMapper.findById(shopCarId);
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setBookId(car.getBookId());
            orderItem.setNum(car.getNum());
            orderItemMapper.save(orderItem);
            shopcarMapper.deleteById(shopCarId);
        }
//        OrderExtend orderExtend = orderMapper.selectOrderDetailById(order.getId());
//        orderExtend.setOrderId(order.getId());
//        List<OrderItemExtend> list = new ArrayList<>();
//        List<OrderItem> byOrderId = orderItemMapper.findByOrderId(order.getId());
//        List<CollectExtend> collectByUserId = collectMapper.findCollectByUserId(parseInt);
//        for (OrderItem orderItem : byOrderId) {
//            OrderItemExtend orderItemExtend = BeanCopyUtils.copyBean(orderItem, OrderItemExtend.class);
//            Collect byUserIdAndBookId = collectMapper.findByUserIdAndBookId(parseInt, orderItemExtend.getBookId());
//            list.add(orderItemExtend);
//        }
//
//        OrderDetailVO orderDetailVO = BeanCopyUtils.copyBean(orderExtend, OrderDetailVO.class);
        return null;

    }

    @Override
    public void paySuccess(OrderPaySuccessDTO paySuccessDTO) {

    }
}
