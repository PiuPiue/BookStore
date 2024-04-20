package com.briup.bookstore.po;


import com.briup.bookstore.constant.BookStoreConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @TableName es_order
 */
@ApiModel("订单实体")
@Data
@Accessors(chain = true)
public class Order {
    /**
     * 订单编号
     */
    @ApiModelProperty("订单编号")
    private String id;

    /**
     * 下单用户
     */
    @ApiModelProperty("下单用户")
    private Integer userId;

    /**
     * 创建订单时间
     */
    @ApiModelProperty("创建订单时间")
    private LocalDateTime createDate;

    /**
     * 支付方式
     */
    @ApiModelProperty("支付方式")
    private String payWay;

    /**
     * 快递单号
     */
    @ApiModelProperty("快递单号")
    private Integer trackingNumber;

    /**
     * 配送方式
     */
    @ApiModelProperty("配送方式")
    private String distributionMode;

    /**
     * 订单状态
     * 1.已创建未支付
     * 2.已支付未发货
     * 3.已发货未收货
     * 4.已收货
     * 5.已关闭 只能关闭 已创建未支付的订单
     */
    @ApiModelProperty("订单状态 1.已创建未支付 2.已支付未发货 3.已发货未收货 4.已收货 5.已关闭 只能关闭 已创建未支付的订单")
    private Integer status;

    /**
     * 支付时间
     */
    @ApiModelProperty("支付时间")
    private LocalDateTime payDate;

    /**
     * 收件人
     */
    @ApiModelProperty("收件人")
    private String receiveUsername;

    /**
     * 收获地址
     */
    @ApiModelProperty("收获地址")
    private String receiveAddress;

    /**
     * 收件人电话
     */
    @ApiModelProperty("收件人电话")
    private String receivePhone;


    public Order() {
        this.id = genOrderId();
        this.createDate = LocalDateTime.now();
        this.status=1;

    }

    private String genOrderId() {
        return BookStoreConstant.ORDER_ID_PREFIX + UUID.randomUUID().toString().replaceAll("-", "");
    }


}