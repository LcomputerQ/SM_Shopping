package com.hp.pojo;

import lombok.Data;

/**
 * 支付参数
 */
@Data
public class AliPay {
//   订单号
    private String traceNo;
//    订单总价
    private double totalAmount;
//    订单名称
    private String subject;
    private String alipayTraceNo;
}
