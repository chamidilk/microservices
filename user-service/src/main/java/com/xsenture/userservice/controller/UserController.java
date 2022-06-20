package com.xsenture.userservice.controller;

import com.xsenture.userservice.dto.UserDto;
import com.xsenture.userservice.dto.UserResponseDto;
import com.xsenture.userservice.entity.User;
import com.xsenture.userservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public UserDto saveUser(@RequestBody UserDto userDto) {
        log.info("save user inside user controller");
        return userService.saveUser(userDto);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable Long id){
        log.info("get user inside user controller");
        return userService.getUser(id);
    }
}
