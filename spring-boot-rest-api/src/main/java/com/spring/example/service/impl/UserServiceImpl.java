package com.spring.example.service.impl;

import com.spring.example.dto.UserDto;
import com.spring.example.embedded.Contact;
import com.spring.example.entities.Address;
import com.spring.example.entities.User;
import com.spring.example.mapper.UserMapper;
import com.spring.example.repository.UserRepository;
import com.spring.example.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=modelMapper.map(userDto,User.class);// Kullanıcıdan gelen userDto nesnesini User'a dönüştürdük.
        user.setCreatedAt(new Date());
        user.setCreatedBy("admin");
        user.setUpdatedAt(new Date());
        user.setContact(new Contact("233444444","mr@gmail.com","55555"));
        user.setAddress(new Address("şenlikköy","florya","istanbul",123));
        return modelMapper.map(userRepository.save(user),UserDto.class); // Burada UserDto nesnesine dönüştürme yaptık..

    }

    @Override
    public List<UserDto> getUsers() {

        List<User> users=userRepository.findAll();
        List<UserDto> userDtos =users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());


        return userDtos ;
    }

    @Override
    public UserDto findById(Long id) {
        Optional<User> user=userRepository.findById(id);
        if (user.isPresent()){   // Aranan kullanıcı sistemde var mı diye kontrol ediyoruz !!!
            return modelMapper.map(user.get(),UserDto.class);

        }
        return null;
    }

    @Override
    public UserDto findByFirstName(String firstname) {
        Optional<User> user = userRepository.findByFirstname(firstname);
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        }
        return null;
    }
}
