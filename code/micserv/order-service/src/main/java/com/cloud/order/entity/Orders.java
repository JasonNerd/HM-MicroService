package com.cloud.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private Long id;
    private Long userId;
    private String name;
    private Double price;
    private Integer num;
}
