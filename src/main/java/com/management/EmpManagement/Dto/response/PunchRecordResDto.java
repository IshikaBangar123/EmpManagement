package com.management.EmpManagement.Dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PunchRecordResDto {

    private String empCode;
    private String TotalTime;
}
