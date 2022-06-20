package com.xsenture.departmentservice.controller;

import com.xsenture.departmentservice.dto.DepartmentDto;
import com.xsenture.departmentservice.entity.Department;
import com.xsenture.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/departments")
@AllArgsConstructor
@Slf4j
public class DepartmentController {


    private final DepartmentService departmentService;


    @PostMapping("/")
    public @ResponseBody DepartmentDto saveDepartment(@RequestBody DepartmentDto departmentDto) {
        log.info("save department method of department controller");
        return departmentService.saveDepartment(departmentDto);
    }

    @GetMapping("/{id}")
    public DepartmentDto getDepartment(@PathVariable(name = "id") long id){
        log.info("get department method of department controller");
        return departmentService.getDepartment(id);
    }
}
