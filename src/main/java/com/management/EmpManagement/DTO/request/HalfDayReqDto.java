package com.management.EmpManagement.DTO.request;

import com.management.EmpManagement.Entity.EmployeeEntity;
import com.management.EmpManagement.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class HalfDayReqDto {

    private Status leaveType;
    private String reason;
    private Date ApplyDate;
    private EmployeeEntity employee;
}
