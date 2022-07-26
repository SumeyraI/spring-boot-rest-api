package com.spring.example.api;

import com.spring.example.dto.UserDto;
import com.spring.example.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {

        this.userService = userService;
    }


    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.createUser(userDto));

    }
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getUsers(){

        List<UserDto> allUser =userService.getUsers();
        return ResponseEntity.ok(allUser);
    }
    @GetMapping({"/getById/{id}"})
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id){

        UserDto getResult = userService.findById(id);
        return ResponseEntity.ok(getResult);

       // return  ResponseEntity.ok(userService.findById(id)); Yukarıdaki kod ile aynı işi yapıyor mu diye kontrol et !!!
    }
    @GetMapping({"/findByName/{firstname}"})
    private ResponseEntity<UserDto> findByName(@PathVariable ("firstname") String firstname){

        UserDto getFirstName =userService.findByFirstName(firstname);
        return ResponseEntity.ok(getFirstName);
    }



}
