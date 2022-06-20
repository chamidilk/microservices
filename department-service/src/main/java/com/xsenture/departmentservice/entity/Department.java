package com.xsenture.departmentservice.entity;


import lombok.*;

import javax.persistence.*;


@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long departmentId;

    String departmentName;
    String departmentAddress;
    String departmentCode;
}
