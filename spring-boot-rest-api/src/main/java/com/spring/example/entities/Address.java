package com.spring.example.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;

    private String street;
    private String district;
    private String city;
    private int postalCode;

    public Address(String street, String district, String city, int postalCode) {
        this.street = street;
        this.district = district;
        this.city = city;
        this.postalCode = postalCode;
    }
}

