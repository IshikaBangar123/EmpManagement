package com.management.EmpManagement.Dto.request;

import com.management.EmpManagement.Entity.EmployeeEntity;
import com.management.EmpManagement.Enum.Action;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalTime;

public class DownloadMonthlyReqDto {

    private Action punchAction;
    private LocalTime inDuration;
    private LocalTime outDuration;
    private LocalDate PunchDate;
    private LocalTime punchRecord;
    private String empCode;
    private String firstName;
    private String lastName;
}
