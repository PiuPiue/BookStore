package com.briup.bookstore.mapper.ext;

import com.briup.bookstore.dto.BookSearchDTO;
import com.briup.bookstore.po.Book;
import com.briup.bookstore.po.ext.BookExtend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookExtendMapper {

    List<BookExtend> selectBooksByCondition( BookSearchDTO bookSearchDTO);

    //    只检索在售状态的书籍信息
    List<BookExtend> selectBooksByConditionAndStatus(@Param("query") String query);

    //    获取图书详细信息
    Book selectBookById(Integer id);

    List<BookExtend>  selectBooksBefore20();
}
