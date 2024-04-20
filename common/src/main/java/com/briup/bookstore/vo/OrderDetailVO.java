package com.briup.bookstore.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName: OrderDetailVO
 * @Description: TODO
 * @Author: songjl
 * @Date: 2023/7/26 09:55
 * @Version: v1.0
 */
@ApiOperation("订单详情对象")
@Data
public class OrderDetailVO {
    @ApiModelProperty("订单编号")
    private String orderId;

    @ApiModelProperty("订单状态  1.已创建未支付 2.已支付未发货 3.已发货未收货 4.已收货 5.已关闭 只能关闭 已创建未支付的订单")
    private Integer status;

    @ApiModelProperty("下单用户名")
    private String username;

    @ApiModelProperty("下单时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createDate;

    @ApiModelProperty("支付时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime payDate;

    @ApiModelProperty("收件人")
    private String receiveUsername;

    @ApiModelProperty("收货地址")
    private String receiveAddress;

    @ApiModelProperty("收货人联系方式")
    private String receivePhone;

    @ApiModelProperty("订单总额")
    private BigDecimal totalPrice;

    @ApiModelProperty("订单商品数")
    private Integer num;

    @ApiModelProperty("支付方式")
    private String payWay;

    @ApiModelProperty("快递单号")
    private Integer trackingNumber;

    @ApiModelProperty("配送方式")
    private String distributionMode;

    @ApiModelProperty("图书信息")
    private List<OrderBookVO> orderItems;

    @ApiModelProperty("订单商品数")
    private Integer totalNum;
}
