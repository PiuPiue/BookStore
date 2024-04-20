package com.briup.bookstore.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: BookVO
 * @Description: 图书信息展示
 * @Author: songjl
 * @Date: 2023/7/20 16:00
 * @Version: v1.0
 */
@ApiModel("图书基础信息展示对象")
@Data
public class BookVO {
    @ApiModelProperty("图书编号")
    /**
     * 图书编号
     */
    private Integer id;
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
     * 图书简介
     */
    @ApiModelProperty("图书简介")
    private String description;
    /**
     * 图书作者
     */
    @ApiModelProperty("图书作者")
    private String author;
    /**
     * 图书价格
     */
    @ApiModelProperty("图书价格")
    private Double price;


}
