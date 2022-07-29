package com.spring.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Category extends BaseEntity{

    private String categoryName;
    private Integer code;




}
