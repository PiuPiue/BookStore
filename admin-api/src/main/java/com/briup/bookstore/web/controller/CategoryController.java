package com.briup.bookstore.web.controller;

import com.briup.bookstore.annotation.SystemLog;
import com.briup.bookstore.dto.CategoryAddDTO;
import com.briup.bookstore.dto.CategoryUpdateDTO;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.CategoryService;
import com.briup.bookstore.vo.CategoryInfoVO;
import com.briup.bookstore.vo.CategoryPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategoryPage")
    @SystemLog(businessName = "得到全部分类")
    public Result getAllCategory(Integer pageNum,
                                 Integer pageSize,
                                 String name ){
        CategoryPageVO categoryPage = categoryService.getCategoryPage(pageNum, pageSize, name);
        return Result.success(categoryPage);
    }

    @GetMapping("/getAllCategory")
    @SystemLog(businessName = "得到全部分类")
    public Result getAllCategory(){
        List<CategoryInfoVO> allCategory = categoryService.getAllCategory();
        return Result.success(allCategory);
    }

    @DeleteMapping("/deleteCategory/{id}")
    @SystemLog(businessName = "删除分类")
    public Result deleteCategory(@PathVariable Integer id){
            categoryService.deleteCategory(id);
            return Result.success();
    }

    @PutMapping("/updateCategory")
    @SystemLog(businessName = "编辑分类")
    public Result updateCategory(@RequestBody CategoryUpdateDTO categoryUpdateDTO){
        categoryService.updateCategory(categoryUpdateDTO);
        return Result.success();
    }

    @PostMapping("/addCategory")
    public Result addCategory(@RequestBody CategoryAddDTO categoryAddDTO){
        categoryService.addCategory(categoryAddDTO);
        return Result.success();
    }


}
