package com.smart.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.smart.address.domain.dto.AddressDto;
import com.smart.user.domain.vo.UserVo;
import okhttp3.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

//http://127.0.0.1:8090/api/user/addresses?uid=1&page=1&size=10

@RestController
@RequestMapping("/user")
public class UserController {
    public static String urlAddress = "http://127.0.0.1:8091/api/address/list";
    @Resource
    OkHttpClient client;

    /**
     * 查询用户的所有地址信息
     */
    @GetMapping("/addresses")
    public UserVo getAddressList(int uid, int page, int size) {
        UserVo vo = new UserVo();
        vo.setUid(uid);
        vo.setUsername("admin");
        RequestBody requestBody = null;
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("username", "admin");
        FormBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(urlAddress + "?" + "uid=" + uid + "&page=" + page + "&size=" + size)
//                .post(formBody)  默认是get请求
                .build();
        //newCall(url地址):发起请求 同步
        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
            List<AddressDto> list = JSONObject.parseArray(response.body().string(),AddressDto.class);
            vo.setAddress(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vo;
    }
}
