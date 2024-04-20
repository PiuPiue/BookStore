package com.briup.bookstore.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author briup-adam
 * @Date 2023/7/26 上午9:23
 * @Description
 **/
@ApiModel("购物车模型数据")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ShopCarVO {
    @ApiModelProperty("购物车ID")
    private  int id;
    /**
     * 购物车数量
     */
    @ApiModelProperty("购物车数量")
    private   Integer num;

    /**
     * 图书名称
     */
    @ApiModelProperty("图书名称")
    private String name;

    /**
     * 图书封面图片
     */
    @ApiModelProperty("图书封面图片")
    private String cover;


    /**
     * 图书价格
     */
    @ApiModelProperty("图书价格")
    private Double price;

    @ApiModelProperty("图书编号")
    private Integer bookId;
}
