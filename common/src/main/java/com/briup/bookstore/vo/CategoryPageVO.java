package com.briup.bookstore.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @className: CategoryPageVO
 * @Description: 分页多条件查询分类列表模型数据
 * @author: qinyc
 * @date: 2023/7/28 13:54
 * @version: v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CategoryPageVO {
    //数据总条数
    private Integer total;

    private List<CategoryInfoVO> categoryList;
}
