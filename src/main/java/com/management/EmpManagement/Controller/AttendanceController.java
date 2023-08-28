package com.management.EmpManagement.Controller;

import com.management.EmpManagement.Dto.request.CheckInReqDto;
import com.management.EmpManagement.Dto.request.CheckOutReqDto;
import com.management.EmpManagement.Dto.request.PunchRecordReqDto;
import com.management.EmpManagement.Entity.Attendance;
import com.management.EmpManagement.Repo.AttendanceRepository;
import com.management.EmpManagement.Service.AttendanceService;
import com.management.EmpManagement.download.CsvService;
import com.management.EmpManagement.download.UserExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/apply")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    private CsvService csvService;

    @PostMapping("/checkIn")
    public ResponseEntity<?> checkInTime(@RequestBody CheckInReqDto checkInReqDto) {
        return this.attendanceService.checkInTime(checkInReqDto);
    }

    @PostMapping("/checkOut")
    public ResponseEntity<?> checkOutTime(@RequestBody CheckOutReqDto checkInReqDto) {
        return this.attendanceService.checkOutTime(checkInReqDto);
    }

    @GetMapping("/totalWorkingHour")
    public ResponseEntity<?> totalWorkingHour(@RequestBody PunchRecordReqDto punchRecordReqDto) {
        return this.attendanceService.totalWorkingHour(punchRecordReqDto);
    }


    @GetMapping("/DOWNLOAD_CSV_FILE")
    public void downloadCsvFile(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        response.setHeader("content-Disposition", "attachment;file-user.csv");
        csvService.downloadCsvFile(response.getWriter());

    }

    @GetMapping("/DOWNLOAD_MONTHLY_EXCEL_FILE")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");

        // Calculate the date range from previous month's start to current date
        LocalDate currentDate = LocalDate.now();
        LocalDate previousMonthStartDate = currentDate.minusMonths(1).withDayOfMonth(1);
        LocalDate endDate = currentDate.minusDays(1); // Subtract one day from current date to cover the whole previous month

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDate.toString() + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Attendance> list = attendanceRepository.findByPunchDateBetween(previousMonthStartDate, endDate);

        UserExcelService excelExporter = new UserExcelService(list);

        excelExporter.export(response);
    }


}

