package com.management.EmpManagement.Dto.response;

import com.management.EmpManagement.Enum.Action;

import java.time.LocalDate;
import java.time.LocalTime;

public class DownloadMonthlyResDto {
    private  Long id;
    private Action punchAction;
    private LocalTime inDuration;
    private LocalTime outDuration;
    private LocalDate PunchDate;
    private LocalTime punchRecord;
    private String empCode;
    private String name;
}
