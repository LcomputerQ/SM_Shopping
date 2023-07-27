package com.hp.pojo;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carts {
    private Integer id;
    private Integer amount;
    private Integer goodId;
    private Integer userId;
}
