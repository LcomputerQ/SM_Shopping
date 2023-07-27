package com.hp.pojo;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Goods {
    private Integer id;
    private String cover;
    private String name;
    private String intro;
    private  String spec;
    private Integer price;
    private Integer stock;
    private Integer sales;
    private String content;
    private Integer typeId;
}
