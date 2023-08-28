package com.management.EmpManagement.DTO;

import com.management.EmpManagement.Enum.Designation;
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

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private String dateOfBirth;
    private String dateOfJoining;
    private String permanentAddress;
    private String localAddress;
    private String companyLocation;
    private String designation;
}
