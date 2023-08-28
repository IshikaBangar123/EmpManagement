package com.management.EmpManagement.Dto;

import com.management.EmpManagement.Enum.Designation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private String empCode;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private Date dateOfBirth;
    private Date dateOfJoining;
    private String permanentAddress;
    private String localAddress;
    private String companyLocation;

    private Designation designation;
}
