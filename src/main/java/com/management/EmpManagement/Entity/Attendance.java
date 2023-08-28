package com.management.EmpManagement.Entity;

import com.management.EmpManagement.Enum.Action;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "attendance_details")
@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;
     private Action punchAction;

    private LocalTime inDuration;

    private LocalTime outDuration;
    private LocalDate punchDate;
    private LocalTime punchRecord;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private EmployeeEntity employee;


}
