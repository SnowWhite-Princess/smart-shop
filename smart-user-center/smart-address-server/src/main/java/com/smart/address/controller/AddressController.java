package com.smart.address.controller;

import com.smart.address.domain.dto.AddressDto;
import com.smart.address.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    AddressService service;
    /**
     * 添加
     * 假删除
     * 更新地址信息
     * 查询单个地址信息
     * 根据用户名查询多个地址信息
     */

    @GetMapping("/list")
    public List<AddressDto> list(@RequestParam int uid, @RequestParam int page, @RequestParam int size) {
        return service.list(uid, page, size);
    }
}
