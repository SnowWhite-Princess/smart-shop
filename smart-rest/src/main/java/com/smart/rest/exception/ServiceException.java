package com.smart.rest.exception;

import com.smart.rest.common.RespCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException {
    private String msg;
    private String tips;
    private int status;

    public ServiceException(RespCode respCode) {
        this.status = respCode.getStatus();
        this.msg= respCode.getMsg();
        this.tips=respCode.getTips();
    }

}