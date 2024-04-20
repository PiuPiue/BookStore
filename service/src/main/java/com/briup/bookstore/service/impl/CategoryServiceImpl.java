package com.briup.bookstore.service.impl;


import com.briup.bookstore.dto.CategoryAddDTO;
import com.briup.bookstore.dto.CategoryUpdateDTO;
import com.briup.bookstore.mapper.BookMapper;
import com.briup.bookstore.mapper.CategoryMapper;
import com.briup.bookstore.po.Category;
import com.briup.bookstore.service.CategoryService;
import com.briup.bookstore.utils.BeanCopyUtils;
import com.briup.bookstore.utils.TreeDataUtils;
import com.briup.bookstore.vo.CategoryInfoVO;
import com.briup.bookstore.vo.CategoryPageVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public CategoryPageVO getCategoryPage(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<Category> categories = categoryMapper.selectAllCategory();
        CategoryPageVO categoryPageVO = new CategoryPageVO();
        List<CategoryInfoVO> list = BeanCopyUtils.copyBeanList(categories, CategoryInfoVO.class);
        categoryPageVO.setCategoryList(TreeDataUtils.convert(list));
        categoryPageVO.setTotal(list.size());
        return categoryPageVO;
    }

    @Override
    public List<CategoryInfoVO> getAllCategory() {
        List<Category> categories = categoryMapper.selectAllCategory();
        List<CategoryInfoVO> list = new ArrayList<>();
        for(Category category:categories){
            CategoryInfoVO categoryInfoVO = BeanCopyUtils.copyBean(category, CategoryInfoVO.class);
            list.add(categoryInfoVO);
        }
        //把集合中的扁平结构转换为树形结构
        list = TreeDataUtils.convert(list);
        return list;
    }

    @Override
    public Category getCategoryById(Integer id) {
        return null;
    }

    @Override
    public void addCategory(CategoryAddDTO categoryAddDTO) {
        Category category = BeanCopyUtils.copyBean(categoryAddDTO, Category.class);
        categoryMapper.insertCategory(category);
    }


    @Override
    public void updateCategory(CategoryUpdateDTO categoryUpdateDTO) {
        Category category = BeanCopyUtils.copyBean(categoryUpdateDTO, Category.class);
        categoryMapper.updateCategoryById(category);
    }


    @Override
    public void deleteCategory(Integer ids) {
        //判断当前封面类是为一级还是二级
        Category category = categoryMapper.selectCategoryById(ids);

        if(category.getParentId()==null){
            categoryMapper.delByParentId(ids);
        }
        categoryMapper.deleteById(ids);

        //如果是二级直接删除
        //如果是一级先删除二级分类

    }
}
