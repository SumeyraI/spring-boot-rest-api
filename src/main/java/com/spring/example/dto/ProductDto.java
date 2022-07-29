package com.spring.example.dto;

import com.spring.example.entities.Basket;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseDto{
    public String name;
    public int price;
    public int amount;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basketId")
    private Basket basket;
}
