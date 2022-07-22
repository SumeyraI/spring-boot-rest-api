package com.spring.example.entities;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Product extends BaseEntity{

    private String name;
    private int price;
    private int stock;
    private int amount;





}
