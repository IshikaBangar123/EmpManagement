package com.management.EmpManagement.DTO.request;

import com.management.EmpManagement.Enum.Status;
import com.management.EmpManagement.Entity.Employee;
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
    private Employee employee;
}
