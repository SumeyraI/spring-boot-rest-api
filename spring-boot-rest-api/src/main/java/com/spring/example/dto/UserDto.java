package com.spring.example.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto{
    private String firstname;
    private String lastName;
}
