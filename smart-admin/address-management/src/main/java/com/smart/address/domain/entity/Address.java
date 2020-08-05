package com.smart.address.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "address")
public class Address {
    @TableId(value = "aid", type = IdType.AUTO)
    private Integer aid;

    @TableField(value = "city")
    private String city;

    @TableField(value = "uid")
    private Integer uid;

    public static final String COL_AID = "aid";

    public static final String COL_CITY = "city";

    public static final String COL_UID = "uid";
}