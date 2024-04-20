package com.briup.bookstore.service;

import com.briup.bookstore.dto.BookSearchDTO;
import com.briup.bookstore.po.Book;
import com.briup.bookstore.po.ext.BookExtend;
import com.briup.bookstore.vo.BookInfoVO;
import com.briup.bookstore.vo.BookVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_book】的数据库操作Service
* @createDate 2023-07-18 21:32:19
*/
public interface BookService {
    BookInfoVO getBookById(Integer bookId, Integer userId);

    BookInfoVO getBookById(Integer bookId );

    PageInfo<BookExtend> getPageBook(Integer pageNum, Integer pageSize, BookSearchDTO bookSearchDTO);

    List<BookVO> getBook(String query);

    void saveBook(Book book);

    void modifyBook(Book book);

    void removeBook(Integer id);

    void modifyStatus(Integer id, Integer status);

    void removeBatchByIds(List<Integer> ids);

    /**
     * @Author qinyc
     * @Description 根据分类ID获取图书信息
     * @Version: v1.0
     * @Date 17:46 2023/7/24
     * @Param :categoryId
     * @Return: java.util.List<com.briup.bookstore.po.Book>
     **/
    List<BookVO> getBooksByCategoryId(Integer categoryId);

    List<BookVO>  showBooks();

    Book showBookById(Integer id);
}
