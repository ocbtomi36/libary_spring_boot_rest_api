package net.myapi.springboot.controller;

import net.myapi.springboot.dto.requestDto.UserRequestDto;
import net.myapi.springboot.dto.responseDto.UserResponseDto;
import net.myapi.springboot.service.UserService;
import net.myapi.springboot.validation.FieldValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private void validate(UserRequestDto user) {
        if(user == null) {
            throw new IllegalArgumentException("user can't be null");
        }
        FieldValidator.notNullFieldValidate(user.getName(),"Name",100);
        FieldValidator.emailValidate(user.getEmail());
        FieldValidator.notNullFieldValidate(user.getPassword(),"Password",100);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto user){
       this.validate(user);
       UserResponseDto savedUser = userService.createUser(user);
       return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") Integer userId){
        UserResponseDto returnUser = userService.getUserById(userId);
        return new ResponseEntity<>(returnUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> responseUsers = userService.getAllUsers();
        return new ResponseEntity<>(responseUsers, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable("id") Integer userId, @RequestBody UserRequestDto user) {
        user.setUserId(userId);
        this.validate(user);
        UserResponseDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
}
