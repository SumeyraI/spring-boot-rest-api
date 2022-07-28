package com.spring.example.service;

import com.spring.example.dto.UserDto;
import java.util.List;

public interface IUserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getUsers();
    UserDto findById(Long id);
    UserDto findByFirstName(String firstname);
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);

}
