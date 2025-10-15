package net.myapi.springboot.service.imp;

import net.myapi.springboot.dto.requestDto.UserRequestDto;
import net.myapi.springboot.dto.responseDto.UserResponseDto;
import net.myapi.springboot.entity.User;
import net.myapi.springboot.exception.DataAlreadyExistException;
import net.myapi.springboot.exception.ResourceNotFoundException;
import net.myapi.springboot.mapper.UserMapper;
import net.myapi.springboot.repository.UserRepository;
import net.myapi.springboot.service.UserService;
import net.myapi.springboot.validation.FieldValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {

        Optional<User> optionalEmail = userRepository.findByEmail(userRequestDto.getEmail());
        FieldValidator.dataAlreadyExistValidate(optionalEmail,"Email");
        Optional<User> optionalName = userRepository.findByName(userRequestDto.getName());
        FieldValidator.dataAlreadyExistValidate(optionalName,"Name");
        User user = UserMapper.mapToUser(userRequestDto);
        User savedUser = userRepository.save(user);
        UserResponseDto savedUserResponseDto = UserMapper.mapToUserResponseDto(savedUser);
        return savedUserResponseDto;
    }
    @Override
    public UserResponseDto getUserById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId.longValue())
        );
        UserResponseDto userResponseDto = UserMapper.mapToUserResponseDto(user);
        return userResponseDto;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> user = userRepository.findAll();
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for (int i = 0; i < user.size(); i++) {
            UserResponseDto userResponseDto = UserMapper.mapToUserResponseDto(user.get(i));
            userResponseDtos.add(userResponseDto);
        }
        return userResponseDtos;
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto) {
        User existingUser = userRepository.findById(userRequestDto.getUserId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userRequestDto.getUserId().longValue())
        );
        // existingUser az amit behozok az id alapján. Kell egy user objektum amely email alapján jön és egy egy amely a név alapján jön.
        Optional<User> optionalEmailUser = userRepository.findByEmail(userRequestDto.getEmail());
        Optional<User> optionalNameUser = userRepository.findByName(userRequestDto.getName());
        if (optionalEmailUser.isPresent() &&
                !optionalEmailUser.get().getIdUser().equals(userRequestDto.getUserId())) {
            throw new DataAlreadyExistException("Email already exists in database");
        }
        if (optionalNameUser.isPresent() &&
                !optionalNameUser.get().getIdUser().equals(userRequestDto.getUserId())) {
            throw new DataAlreadyExistException("Name already exists in database");
        }
        existingUser.setName(userRequestDto.getName());
        existingUser.setEmail(userRequestDto.getEmail());
        existingUser.setPassword(userRequestDto.getPassword());
        User updatingUser = userRepository.save(existingUser);
        return UserMapper.mapToUserResponseDto(updatingUser);
    }
}
