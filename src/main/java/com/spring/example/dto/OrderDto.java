package com.spring.example.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto extends BaseDto{

    private String name;
    private Integer orderCount;
    private Double amount;
    private String code;
}
