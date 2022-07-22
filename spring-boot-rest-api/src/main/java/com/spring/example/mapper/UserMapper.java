package com.spring.example.mapper;

import com.spring.example.dto.UserDto;
import com.spring.example.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

    List<UserDto> userToUserDtos(List<User> users);

    List<User> userDtoToUsers(List<UserDto> userDtos);
}
