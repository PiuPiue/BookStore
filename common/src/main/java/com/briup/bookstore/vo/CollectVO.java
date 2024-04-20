package com.briup.bookstore.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author briup-adam
 * @Date 2023/7/26 下午2:04
 * @Description  收藏信息展示
 **/
@ApiModel("图书基础信息展示对象")
@Data
public class CollectVO {
    @ApiModelProperty("收藏ID")
    private  int id;

    @ApiModelProperty("图书名称")
    private String name;

    @ApiModelProperty("图书封面图片")
    private String cover;

    @ApiModelProperty("图书价格")
    private Double price;

    @ApiModelProperty("图书编号")
    private Integer bookId;
}
