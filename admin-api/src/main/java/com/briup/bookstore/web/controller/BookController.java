package com.briup.bookstore.web.controller;

import com.briup.bookstore.annotation.SystemLog;
import com.briup.bookstore.dto.BookSearchDTO;
import com.briup.bookstore.po.Book;
import com.briup.bookstore.po.ext.BookExtend;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.BookService;
import com.briup.bookstore.vo.BookInfoVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id1}/{id2}")
    @SystemLog(businessName = "获取书籍")
    public Result getBooks(@PathVariable Integer id1, @PathVariable Integer id2, BookSearchDTO bookSearchDTO){
        PageInfo<BookExtend> pageBook = bookService.getPageBook(id1, id2, bookSearchDTO);
        return Result.success(pageBook);
    }

    @DeleteMapping
    @SystemLog(businessName = "删除书籍")
    public Result delete(@RequestBody Integer ... integers){
        for (Integer integer : integers) {
            bookService.removeBook(integer);
        }
        return Result.success();
    }

    @PutMapping("/{id1}/{id2}")
    @SystemLog(businessName = "改变图书状态")
    public Result changeStatus(@PathVariable Integer id1,@PathVariable Integer id2){
        bookService.modifyStatus(id1,id2);
        return Result.success();
    }

    @GetMapping("/backend/{id}")
    @SystemLog(businessName = "书籍详细信息映射")
    public Result bookBackEnd(@PathVariable Integer id){
        BookInfoVO bookById = bookService.getBookById(id);
        return Result.success(bookById);
    }

    @PutMapping("/{id}/{status}")
    public Result modifyStatus(@PathVariable Integer id, @PathVariable Integer status){
        bookService.modifyStatus(id,status);
        return Result.success();
    }


    @PostMapping
    @SystemLog(businessName = "添加书籍")
    public Result addBook(@RequestBody Book book){
        bookService.saveBook(book);
        return Result.success();
    }

    @PutMapping
    public Result modifyBook(@RequestBody Book book){
        bookService.modifyBook(book);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteBookById(@PathVariable Integer id){
        bookService.removeBook(id);
        return Result.success();
    }

}
