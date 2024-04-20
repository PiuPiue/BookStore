package com.briup.bookstore.service;

import com.briup.bookstore.dto.AddressAddDTO;
import com.briup.bookstore.dto.AddressUpdateDTO;
import com.briup.bookstore.vo.AddressVO;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_address】的数据库操作Service
* @createDate 2023-07-18 21:33:00
*/
public interface AddressService {
    List<AddressVO> findAddresses(Integer userId);

    void  save(AddressAddDTO addressAddDTO);

     void  update (AddressUpdateDTO addressUpdateDTO);

     void  setDefaultAddress(Integer userId,Integer addressId);

     void cancelDefaultAddress( Integer addressId) ;


     void  delete(Integer  id);



}
