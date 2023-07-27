package com.hp.pojo;


import lombok.*;

@Data
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Items {
    private Integer id;
    private Integer price;
    private Integer amount;
    private Integer orderId;
    private Integer goodId;
}
