package com.hp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;


@Data
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Orders {
    private Integer id;
    private Double total;
    private Double amount;
    private Integer status;
    private Integer paytype;
    private String name;
    private String phone;
    private String address;
    private Date systime;
    private Integer userId;
}
