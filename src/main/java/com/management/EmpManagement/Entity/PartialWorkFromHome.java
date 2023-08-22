package com.management.EmpManagement.Entity;

import com.management.EmpManagement.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "partial_wfh")
@Entity
public class PartialWorkFromHome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pwId;
    private Status leaveType;
    private String reason;
    private Date ApplyDate;
    private Date startDate;
    private Date endDate;
    private Time timeOfPartialDay;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private EmployeeEntity employee;

}
