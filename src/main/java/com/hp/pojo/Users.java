package com.hp.pojo;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Users {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String address;
}
