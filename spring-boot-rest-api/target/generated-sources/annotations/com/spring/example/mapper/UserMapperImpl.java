package com.spring.example.mapper;

import com.spring.example.dto.UserDto;
import com.spring.example.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-20T11:29:12+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setCreatedAt( userDto.getCreatedAt() );
        user.setCreatedBy( userDto.getCreatedBy() );
        user.setUpdatedAt( userDto.getUpdatedAt() );
        user.setUpdatedBy( userDto.getUpdatedBy() );

        return user;
    }

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setCreatedAt( user.getCreatedAt() );
        userDto.setCreatedBy( user.getCreatedBy() );
        userDto.setUpdatedAt( user.getUpdatedAt() );
        userDto.setUpdatedBy( user.getUpdatedBy() );

        return userDto;
    }

    @Override
    public List<UserDto> userToUserDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( userToUserDto( user ) );
        }

        return list;
    }

    @Override
    public List<User> userDtoToUsers(List<UserDto> userDtos) {
        if ( userDtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDtos.size() );
        for ( UserDto userDto : userDtos ) {
            list.add( userDtoToUser( userDto ) );
        }

        return list;
    }
}
