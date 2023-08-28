package com.management.EmpManagement.DTO.request;

import com.management.EmpManagement.Entity.EmployeeEntity;
import com.management.EmpManagement.Enum.Status;
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

public class PartialReqDto {

    private Status leaveType;
    private String reason;
    private Date ApplyDate;
    private Time timeOfPartialDay;
    private EmployeeEntity employee;
}
