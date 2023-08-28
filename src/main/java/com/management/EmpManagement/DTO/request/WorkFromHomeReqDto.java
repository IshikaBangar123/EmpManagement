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

public class WorkFromHomeReqDto {

    private Status leaveType;
    private String reason;
    private Date ApplyDate;
    private Date startDate;
    private Date endDate;
    private EmployeeEntity employee;
}
