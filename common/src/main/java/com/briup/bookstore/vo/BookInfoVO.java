package com.briup.bookstore.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author briup-adam
 * @Date 2023/7/25 下午4:53
 * @Description
 **/
@ApiModel("图书详细信息展示对象")
@Data
public class BookInfoVO {

    @ApiModelProperty("图书编号")
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
     * 图书出版社
     */
    @ApiModelProperty("图书出版社")
    private String publisher;

    /**
     * 图书价格
     */
    @ApiModelProperty("图书价格")
    private Double price;

    /**
     * 库存数量
     */
    @ApiModelProperty("库存数量")
    private Integer storeNum;


    /**
     * 图书分类名称
     */
    @ApiModelProperty("图书分类名称")
    private String  categoryName;

    @ApiModelProperty("当前用户是否收藏该书籍")
    private boolean collect;

}
