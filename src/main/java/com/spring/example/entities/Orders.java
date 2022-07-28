package com.spring.example.entities;

import lombok.*;
import javax.persistence.*;


@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders extends BaseEntity{
    private String name;
    private Integer orderCount;
    private Double amount;
    private String code;
}
