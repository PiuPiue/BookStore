package com.briup.bookstore.service.impl;

import com.briup.bookstore.dto.BookSearchDTO;
import com.briup.bookstore.mapper.*;
import com.briup.bookstore.mapper.ext.BookExtendMapper;
import com.briup.bookstore.po.Book;
import com.briup.bookstore.po.Collect;
import com.briup.bookstore.po.User;
import com.briup.bookstore.po.ext.BookExtend;
import com.briup.bookstore.service.BookService;
import com.briup.bookstore.utils.BeanCopyUtils;
import com.briup.bookstore.vo.BookInfoVO;
import com.briup.bookstore.vo.BookVO;
import com.briup.bookstore.vo.UserPageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookExtendMapper bookExtendMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private CollectMapper collectMapper;

    @Autowired
    private ShopcarMapper shopcarMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public BookInfoVO getBookById(Integer bookId, Integer userId) {
        Book book = bookExtendMapper.selectBookById(bookId);
        BookInfoVO bookInfoVO = BeanCopyUtils.copyBean(book, BookInfoVO.class);
        Collect byUserIdAndBookId = collectMapper.findByUserIdAndBookId(userId, bookId);
        if(byUserIdAndBookId!=null)
            bookInfoVO.setCollect(true);
        return bookInfoVO;
    }

    @Override
    public BookInfoVO getBookById(Integer bookId) {
        Book book = bookExtendMapper.selectBookById(bookId);
        BookInfoVO bookInfoVO = BeanCopyUtils.copyBean(book, BookInfoVO.class);
        return bookInfoVO;
    }

    @Override
    public PageInfo<BookExtend> getPageBook(Integer pageNum, Integer pageSize, BookSearchDTO bookSearchDTO) {
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        //对应查询
        List<BookExtend> list = bookExtendMapper.selectBooksByCondition(bookSearchDTO);
        List<BookExtend> bookExtends = BeanCopyUtils.copyBeanList(list, BookExtend.class);
        PageInfo<BookExtend> bookExtendPageInfo = new PageInfo<BookExtend>(bookExtends);
        return bookExtendPageInfo;
    }

    @Override
    public List<BookVO> getBook(String query) {
        return null;
    }

    @Override
    public void saveBook(Book book) {
        bookMapper.insertBook(book);
    }


    @Override
    public void modifyBook(Book book) {
        bookMapper.updateBook(book);
    }


    @Override
    public void removeBook(Integer id) {
        //删除对应收藏
        collectMapper.deleteById(id);
        //继续删除
        shopcarMapper.deleteByBookId(id);
        String orderId = orderItemMapper.selectOrderIdById(id);
        orderItemMapper.deleteByBookId(id);
        orderMapper.deleteById(orderId);
        //删除图书
        bookMapper.deleteBookById(id);
    }


    @Override
    public void modifyStatus(Integer id, Integer status) {
        bookMapper.updateBookStatus(id,status);
    }

    @Override
    public void removeBatchByIds(List<Integer> ids) {

    }

    @Override
    public List<BookVO> getBooksByCategoryId(Integer categoryId) {
        List<Book> books = bookMapper.selectBooksByCategoryId(categoryId);
        List<BookVO> list = new ArrayList<>();
        for(Book book:books){
            BookVO bookVO = BeanCopyUtils.copyBean(book, BookVO.class);
            list.add(bookVO);
        }
        return list;
    }

    @Override
    public List<BookVO> showBooks() {
        List<BookExtend> bookExtends = bookExtendMapper.selectBooksBefore20();
        List<BookVO> list = new ArrayList<>();
        for(BookExtend bookExtend:bookExtends){
            BookVO bookVO = BeanCopyUtils.copyBean(bookExtend, BookVO.class);
            list.add(bookVO);
        }
        return list;
    }

    @Override
    public Book showBookById(Integer id) {
        return null;
    }
}
