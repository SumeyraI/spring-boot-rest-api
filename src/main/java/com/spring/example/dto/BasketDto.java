package com.spring.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDto extends BaseDto{

    private int countOfProduct;
    private double amountOfProduct;
}
