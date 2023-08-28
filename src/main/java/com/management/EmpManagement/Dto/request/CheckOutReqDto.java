package com.management.EmpManagement.Dto.request;

import com.management.EmpManagement.Entity.EmployeeEntity;
import com.management.EmpManagement.Enum.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CheckOutReqDto {
    private String empCode;
    private LocalDate PunchDate;
    private Action punchAction;


}
