package com.management.EmpManagement.DTO.response;

import com.management.EmpManagement.Enum.Status;
import com.management.EmpManagement.Entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class PartialResDto {
    private Long pwId;
    private Status leaveType;
    private String reason;
    private Date ApplyDate;
    private Time timeOfPartialDay;
    private Employee employee;
}
