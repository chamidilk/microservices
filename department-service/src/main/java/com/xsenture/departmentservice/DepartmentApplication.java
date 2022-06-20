package com.xsenture.departmentservice;

import com.xsenture.departmentservice.service.DepartmentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DepartmentApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DepartmentApplication.class, args);
        DepartmentService departmentService = applicationContext.getBean(DepartmentService.class);


    }
}
