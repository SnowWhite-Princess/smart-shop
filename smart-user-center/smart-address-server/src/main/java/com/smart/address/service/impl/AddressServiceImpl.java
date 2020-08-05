package com.smart.address.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.address.domain.dto.AddressDto;
import com.smart.address.domain.entity.Address;
import com.smart.address.mapper.AddressMapper;
import com.smart.address.service.AddressService;
import com.smart.address.utils.ColaBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    AddressMapper mapper;

    @Override
    public List<AddressDto> list(int uid, int page, int size) {
        List<AddressDto> dtoList = new ArrayList<>();
        QueryWrapper<Address> qw = new QueryWrapper<>();
        qw.eq(Address.COL_MID, uid);
        IPage<Address> addressPage = mapper.selectPage(new Page<Address>(), qw);
        if (addressPage != null && addressPage.getRecords().size() > 0) {
            dtoList = ColaBeanUtils.copyListProperties(addressPage.getRecords(), AddressDto::new);
        }

        return dtoList;
    }
}
