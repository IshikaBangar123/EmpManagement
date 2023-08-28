package com.management.EmpManagement.Repo;

import com.management.EmpManagement.Entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {


    List<Attendance> findByEmployeeEmpId(String empId);
    List<Attendance> findByPunchDateBetween(LocalDate startDate, LocalDate endDate);

    List<Attendance> findByEmployeeEmpIdAndPunchDate(String empId, LocalDate punchDate);
}
