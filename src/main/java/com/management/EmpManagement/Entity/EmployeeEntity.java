package com.management.EmpManagement.Entity;

import com.management.EmpManagement.Enum.Designation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empCode;
    @NotNull(message = "firstName cannot be null")
    private String firstName;
    @NotNull(message = "lastName cannot be null")
    private String lastName;
    @NotNull(message = "email cannot be null")
    @Email(message = "Email is not correct",regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @NotNull(message = "mobileNo cannot be null")
    @Pattern(regexp="(^$|[0-9]{10})", message = "mobile no. is not correct")
    private String mobileNo;
    @NotNull(message = "dateOfBirth cannot be null")
    private Date dateOfBirth;
    @NotNull(message = "dateOfJoining cannot be null")
    private Date dateOfJoining;
    @NotNull(message = "permanentAddress cannot be null")
    private String permanentAddress;
    @NotNull(message = "localAddress cannot be null")
    private String localAddress;
    @NotNull(message = "companyLocation cannot be null")
    private String companyLocation;
    @NotNull(message = "designation cannot be null")
    @Enumerated(EnumType.STRING)
    private Designation designation;

}