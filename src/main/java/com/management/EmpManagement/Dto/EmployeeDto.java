package com.management.EmpManagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String empId;
    private String empName;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private String permanentAddress;
    private String localAddress;
}
