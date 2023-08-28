package com.management.EmpManagement.download;

import com.management.EmpManagement.Entity.Attendance;
import com.management.EmpManagement.Repo.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.List;

@Service
public class CsvService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public void downloadCsvFile(PrintWriter printWriter) {
        printWriter.write("sNo" + " " + "empId" + " " + "empName" + " " + "inDuration" + " " + "outDuration"+" punchDate"+"\n");


        List<Attendance> attendances = attendanceRepository.findAll();

        for (Attendance book : attendances) {
            printWriter.write(book.getSno()
                    + "," + book.getEmployee().getEmpId() + "," + book.getEmployee().getEmpName()
                    + "," + book.getInDuration() + "," + book.getOutDuration() + book.getPunchDate() + "\n");

        }

    }


}