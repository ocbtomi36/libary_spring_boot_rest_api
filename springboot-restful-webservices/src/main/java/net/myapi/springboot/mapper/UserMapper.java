package net.myapi.springboot.mapper;

import net.myapi.springboot.dto.requestDto.UserRequestDto;
import net.myapi.springboot.dto.responseDto.UserResponseDto;
import net.myapi.springboot.entity.User;

import java.time.LocalDateTime;

public class UserMapper {

    // Requestből usert gyártani
    // Userbol response-t
// String name, String email, String password, LocalDateTime registrationDate
    public static User mapToUser(UserRequestDto userRequestDto){

        User user = new User(
                userRequestDto.getName(),
                userRequestDto.getEmail(),
                userRequestDto.getPassword(),
                LocalDateTime.now()
        );
        return user;
    }

    public static UserResponseDto mapToUserResponseDto(User user){
        UserResponseDto userResponseDto = new UserResponseDto(
                user.getIdUser(),
                user.getName(),
                user.getEmail()
        );
        return userResponseDto;
    }

}
