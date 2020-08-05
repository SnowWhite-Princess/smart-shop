package com.smart.rest.domain.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@ApiModel("用户请求参数")
public class UserRequestParam {
    private String keyword;
    private String password;
}