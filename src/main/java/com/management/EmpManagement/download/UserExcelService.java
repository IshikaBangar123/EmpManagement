package com.management.EmpManagement.download;


import com.management.EmpManagement.Entity.Attendance;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.List;

import static org.apache.poi.ss.util.CellUtil.createCell;

@Service
public class UserExcelService {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Attendance> attendances;

    public UserExcelService(List<Attendance> attendances) {
        this.attendances = attendances;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("AttendanceData");

        Row row = sheet.createRow(0);
        CellStyle style = createHeaderStyle();

        createCell(row, 0, "sno", style);
        createCell(row, 1, "empId", style);
        createCell(row, 2, "empName", style);
        createCell(row, 3, "inDuration", style);
        createCell(row, 4, "outDuration", style);
        createCell(row, 5, "punchDate", style);
        createCell(row, 6, "punchRecord", style);
    }

    private CellStyle createHeaderStyle() {
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 16);
        style.setFont(font);
        return style;
    }

    // createCell method remains mostly unchanged

    private void writeDataLines() {
        int rowCount = 1;
        CellStyle style = createDataStyle();

        for (Attendance b : attendances) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, String.valueOf(b.getSno()), style);
            createCell(row, columnCount++, String.valueOf(b.getEmployee().getId()), style);
            createCell(row, columnCount++, b.getEmployee().getEmpCode(), style);
            createCell(row, columnCount++, String.valueOf(b.getInDuration()), style);
            createCell(row, columnCount++, String.valueOf(b.getOutDuration()), style);
            createCell(row, columnCount++, String.valueOf(b.getPunchDate()), style);
            createCell(row, columnCount++, String.valueOf(b.getPunchRecord()), style);
        }
    }

    private CellStyle createDataStyle() {
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 14);
        style.setFont(font);
        return style;
    }

    public void export(HttpServletResponse response) throws IOException {
        try (OutputStream outputStream = response.getOutputStream()) {
            writeHeaderLine();
            writeDataLines();
            workbook.write(outputStream);
        } finally {
            workbook.close();
        }
    }
}