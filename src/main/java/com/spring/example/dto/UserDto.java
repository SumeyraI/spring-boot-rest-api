package com.spring.example.dto;

import com.spring.example.entities.Address;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto extends BaseDto{

    private String firstname;
    private String lastName;
    private Address address;
}
