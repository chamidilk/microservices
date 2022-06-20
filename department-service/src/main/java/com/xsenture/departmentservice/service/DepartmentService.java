package com.xsenture.departmentservice.service;

import com.xsenture.departmentservice.dto.DepartmentDto;
import com.xsenture.departmentservice.entity.Department;
import com.xsenture.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        log.info("save department inside department service");

        Department department = Department.builder()
                .departmentAddress(departmentDto.departmentAddress())
                .departmentCode(departmentDto.departmentCode())
                .departmentName(departmentDto.departmentName()).build();

        departmentRepository.save(department);

        

        return DepartmentDto.builder()
                .departmentId(department.getDepartmentId())
                .departmentAddress(department.getDepartmentAddress())
                .departmentName(department.getDepartmentName())
                .departmentCode(department.getDepartmentCode()).build();
    }

    public DepartmentDto getDepartment(long id) {
        log.info("get department inside department service");

        Optional<Department> optionalDepartment = departmentRepository.findById(id);

        if(optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            return DepartmentDto.builder()
                    .departmentId(department.getDepartmentId())
                    .departmentAddress(department.getDepartmentAddress())
                    .departmentName(department.getDepartmentName())
                    .departmentCode(department.getDepartmentCode()).build();
        }
        return DepartmentDto.builder().build();
    }
}
