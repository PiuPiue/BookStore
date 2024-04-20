package com.briup.bookstore.po.ext;

import com.briup.bookstore.po.Shopcar;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author briup-adam
 * @Date 2023/7/26 上午9:15
 * @Description
 **/
@ApiModel("购物车拓展类")
@Data
public class ShopCarExtend extends Shopcar {


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


}
