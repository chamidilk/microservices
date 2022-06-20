package com.xsenture.userservice.dto;

import lombok.Builder;

@Builder
public record UserDto(String firstName, String lastName, String email, Long departmentId, Long userId) {
}
