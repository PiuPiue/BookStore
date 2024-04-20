package com.briup.bookstore.mapper;

import com.briup.bookstore.po.Collect;
import com.briup.bookstore.po.ext.CollectExtend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author briup-adam
 * @Date 2023/7/26 上午9:02
 * @Description 针对表【es_collect】的数据库操作Mapper
 **/
@Repository
public interface CollectMapper {

    List<CollectExtend> findCollectByUserId(@Param("userId") Integer userId);

    void  save(@Param("userId") Integer userId,@Param("bookId") Integer bookId);

    void deleteById(@Param("id") Integer id);

    Collect findByUserIdAndBookId(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

    void deleteByUserId(String uid);
}
