package com.xsenture.userservice.dto;

import com.xsenture.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    UserDto userDto;
    DepartmentDto departmentDto;
}
