package com.spring.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket extends BaseEntity{

    private int countOfProduct;
    private double amountOfProduct;

}
