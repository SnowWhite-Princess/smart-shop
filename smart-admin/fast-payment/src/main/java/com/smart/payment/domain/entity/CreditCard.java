package com.smart.payment.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "credit_card")
public class CreditCard {
    /**
     * 银行编号
     */
    @TableId(value = "card_id", type = IdType.AUTO)
    private Integer cardId;

    /**
     * 银行卡号
     */
    @TableField(value = "card_num")
    private String cardNum;

    /**
     * 银行名称 
     */
    @TableField(value = "card_name")
    private String cardName;

    /**
     * 银行卡状态
     */
    @TableField(value = "card_status")
    private Integer cardStatus;

    public static final String COL_CARD_ID = "card_id";

    public static final String COL_CARD_NUM = "card_num";

    public static final String COL_CARD_NAME = "card_name";

    public static final String COL_CARD_STATUS = "card_status";
}