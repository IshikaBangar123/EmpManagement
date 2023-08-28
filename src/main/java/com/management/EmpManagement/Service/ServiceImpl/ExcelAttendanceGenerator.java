package com.management.EmpManagement.Service.ServiceImpl;

import com.management.EmpManagement.Entity.Attendance;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ExcelAttendanceGenerator {

    public void generateMonthlyAttendanceExcel(List<Attendance> attendanceRecords, String employeeName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Monthly Attendance");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("SNO");
        headerRow.createCell(1).setCellValue("Action");
        headerRow.createCell(2).setCellValue("In Duration");
        headerRow.createCell(3).setCellValue("Out Duration");
        headerRow.createCell(4).setCellValue("Punch Date");
        headerRow.createCell(5).setCellValue("Punch Record");

        // Add attendance records to the sheet
        int rowNum = 1;
        for (Attendance attendance : attendanceRecords) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(attendance.getSno());
            row.createCell(1).setCellValue(attendance.getPunchAction().toString());
            row.createCell(2).setCellValue(attendance.getInDuration().toString());
            row.createCell(3).setCellValue(attendance.getOutDuration().toString());
            row.createCell(4).setCellValue(attendance.getPunchDate().toString());
            row.createCell(5).setCellValue(attendance.getPunchRecord().toString());
        }

        // Save the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream(employeeName + "_monthly_attendance.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
