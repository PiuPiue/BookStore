package com.briup.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author briup-adam
 * @Date 2023/7/27 下午2:38
 * @Description
 **/

@Data
@ApiModel("创建订单数据传输对象")
public class OrderCreateDTO {


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


    @ApiModelProperty("选购信息 购物车id")
    private List<Integer> shopCarIds;


}
