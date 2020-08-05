package com.smart.address.service;

import com.smart.address.domain.dto.AddressDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> list(int uid,int page,int size);

}
