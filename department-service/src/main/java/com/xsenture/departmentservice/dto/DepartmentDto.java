package com.xsenture.departmentservice.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record DepartmentDto(Long departmentId, String departmentName, String departmentAddress,
                            String departmentCode) implements Serializable {
}
