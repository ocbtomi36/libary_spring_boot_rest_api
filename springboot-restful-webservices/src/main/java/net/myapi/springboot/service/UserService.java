package net.myapi.springboot.service;

import net.myapi.springboot.dto.requestDto.UserRequestDto;
import net.myapi.springboot.dto.responseDto.UserResponseDto;
import net.myapi.springboot.entity.User;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto user);
    UserResponseDto getUserById(Integer userId);

    List<UserResponseDto> getAllUsers();
    UserResponseDto updateUser(UserRequestDto user);
}
