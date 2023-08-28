package com.management.EmpManagement.Dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PunchRecordReqDto {


    private String empId;
    private Long id;
    private LocalTime inDuration;
    private LocalTime outDuration;
    private LocalDate PunchDate;
}
