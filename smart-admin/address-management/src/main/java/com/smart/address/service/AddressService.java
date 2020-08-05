package com.smart.address.service;

import com.smart.address.common.RespEntity;
import com.smart.address.domain.entity.Address;

public interface AddressService {
    RespEntity<Address> findAll();
    int saveAddress();
    int updateAddress();
    int delAddress();
}
