package com.management.EmpManagement.Dto.response;

import com.management.EmpManagement.Entity.EmployeeEntity;
import com.management.EmpManagement.Enum.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CheckOutResDto {
    private Long sno;
    private String empCode;
    private LocalDate PunchDate;
    private LocalTime outDuration;
    private Action punchAction;

}
