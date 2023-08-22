package com.management.EmpManagement.Dto.response;

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

public class WorkFromHomeResDto {

    private Long pwId;
    private Status leaveType;
    private String reason;
    private Date startDate;
    private Date endDate;
    private EmployeeEntity employee;
}
