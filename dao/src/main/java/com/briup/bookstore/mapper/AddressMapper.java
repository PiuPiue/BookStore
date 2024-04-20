package com.briup.bookstore.mapper;

import com.briup.bookstore.dto.AddressAddDTO;
import com.briup.bookstore.dto.AddressUpdateDTO;
import com.briup.bookstore.po.ext.AddressExtend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_address】的数据库操作Mapper
* @createDate 2023-07-18 21:33:00
* @Entity com.briup.bookstore.po.Address
*/
@Repository
public interface AddressMapper {
    List<AddressExtend> findByUserId(@Param("userId") Integer userId);

    void  update(AddressUpdateDTO addressUpdateDTO);

    void  save(AddressAddDTO addressAddDTO);


    void  deleteById(@Param("id") Integer id);

    void deleteByUserId (String userId);

}




