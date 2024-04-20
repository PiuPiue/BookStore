package com.briup.bookstore.web.controller;

import com.briup.bookstore.annotation.SystemLog;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.CategoryService;
import com.briup.bookstore.vo.CategoryInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @SystemLog(businessName = "查找分类")
    public Result getCategoryList(){
        List<CategoryInfoVO> allCategory = categoryService.getAllCategory();
        return Result.success(allCategory);
    }

}
