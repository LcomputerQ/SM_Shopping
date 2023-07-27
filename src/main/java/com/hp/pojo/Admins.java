package com.hp.pojo;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admins {
    private Integer id;
    private String username;
    private String password;
}
