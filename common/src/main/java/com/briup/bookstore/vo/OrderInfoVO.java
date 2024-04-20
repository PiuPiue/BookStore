package com.briup.bookstore.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author briup-adam
 * @Date 2023/7/27 下午5:20
 * @Description
 **/
@ApiModel("订单展示信息视图对象")
@Data
public class OrderInfoVO {
    @ApiModelProperty("订单编号")
    private String orderId;

    @ApiModelProperty("订单状态  1.已创建未支付 2.已支付未发货 3.已发货未收货 4.已收货 5.已关闭 只能关闭 已创建未支付的订单")
    private Integer status;

    @ApiModelProperty("下单用户名")
    private String username;

    @ApiModelProperty("下单时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createDate;

    @ApiModelProperty("收件人")
    private String receiveUsername;

    @ApiModelProperty("收货地址")
    private String receiveAddress;

    @ApiModelProperty("收货人联系方式")
    private String receivePhone;

    @ApiModelProperty("订单总额")
    private BigDecimal totalPrice;

    @ApiModelProperty("订单商品数")
    private Integer totalNum;

}
