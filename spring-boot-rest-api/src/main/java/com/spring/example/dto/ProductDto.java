package com.spring.example.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseDto{
    private String name;
    private int price;
    private int amount;
}
