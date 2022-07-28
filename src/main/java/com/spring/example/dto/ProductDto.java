package com.spring.example.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseDto{
    public String name;
    public int price;
    public int amount;
    private String description;
}
