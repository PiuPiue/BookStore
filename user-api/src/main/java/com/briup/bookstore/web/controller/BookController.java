package com.briup.bookstore.web.controller;

import com.briup.bookstore.*;
import com.briup.bookstore.annotation.SystemLog;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.BookService;
import com.briup.bookstore.service.UserService;
import com.briup.bookstore.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/showBooks")
    @SystemLog(businessName = "展示书籍")
    public Result showBooks(){
        List<BookVO> list = bookService.showBooks();
        return Result.success(list);
    }

    @GetMapping("/{id}")
    @SystemLog(businessName = "根据id查找书籍")
    public Result getBookById(@PathVariable Integer id, HttpServletRequest request){
        String userId = (String)request.getAttribute("userId");
        return Result.success(bookService.getBookById(id, Integer.valueOf(userId)));
    }

    @GetMapping("/findByCategory/{id}")
    @SystemLog(businessName = "根据分类查找书籍")
    public Result findByCategory(@PathVariable Integer id){
        return Result.success(bookService.getBooksByCategoryId(id));
    }

}
