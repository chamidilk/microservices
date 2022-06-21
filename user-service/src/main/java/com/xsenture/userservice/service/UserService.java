package com.xsenture.userservice.service;

import com.xsenture.userservice.dto.DepartmentDto;
import com.xsenture.userservice.dto.UserDto;
import com.xsenture.userservice.dto.UserResponseDto;
import com.xsenture.userservice.entity.User;
import com.xsenture.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final RestTemplate departmentApi;

    public UserDto saveUser(UserDto userDto) {
        log.info("save user inside user service");

        User user = userRepository.save(User.builder()
                .departmentId(userDto.departmentId())
                .firstName(userDto.firstName())
                .lastName(userDto.lastName())
                .email(userDto.email())
                .build());

        return UserDto.builder()
                .userId(user.getUserId())
                .departmentId(user.getDepartmentId())
                .firstName(user.getFirstName())
                .lastName(userDto.lastName())
                .email(userDto.email())
                .build();
    }

    public UserResponseDto getUser(Long id) {
        log.info("get user inside user service");
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            DepartmentDto departmentDto = departmentApi.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), DepartmentDto.class);

            return UserResponseDto.builder()
                    .userDto(UserDto.builder()
                            .email(user.getEmail())
                            .firstName(user.getFirstName())
                            .lastName(user.getLastName()).build())
                    .departmentDto(departmentDto).build();
        }

        return UserResponseDto.builder().build();
    }
}
