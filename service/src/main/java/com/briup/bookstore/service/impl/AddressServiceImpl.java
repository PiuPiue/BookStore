package com.briup.bookstore.service.impl;

import com.briup.bookstore.dto.AddressAddDTO;
import com.briup.bookstore.dto.AddressUpdateDTO;
import com.briup.bookstore.mapper.AddressMapper;
import com.briup.bookstore.po.ext.AddressExtend;
import com.briup.bookstore.service.AddressService;
import com.briup.bookstore.utils.BeanCopyUtils;
import com.briup.bookstore.vo.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddressVO> findAddresses(Integer userId) {
        List<AddressExtend> address = addressMapper.findByUserId(userId);
        List<AddressVO> list = new ArrayList<>();
        for (AddressExtend addressExtend:address){
            AddressVO addressVO = BeanCopyUtils.copyBean(addressExtend, AddressVO.class);
            list.add(addressVO);
        }
        return list;
    }

    @Override
    public void save(AddressAddDTO addressAddDTO) {
        addressMapper.save(addressAddDTO);
    }

    @Override
    public void update(AddressUpdateDTO addressUpdateDTO) {

    }

    @Override
    public void setDefaultAddress(Integer userId, Integer addressId) {

    }

    @Override
    public void cancelDefaultAddress(Integer addressId) {

    }

    @Override
    public void delete(Integer id) {

    }
}
