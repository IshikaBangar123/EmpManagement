package com.management.EmpManagement.Service;


import com.management.EmpManagement.Dto.request.CheckInReqDto;
import com.management.EmpManagement.Dto.request.CheckOutReqDto;
import com.management.EmpManagement.Dto.request.PunchRecordReqDto;
import com.management.EmpManagement.Entity.Attendance;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface AttendanceService {


 //   public ResponseEntity<?> applyForPartial(PartialReqDto partialReqDto);

    public ResponseEntity<?> checkInTime(CheckInReqDto checkInReqDto);
    public ResponseEntity<?> checkOutTime(CheckOutReqDto checkInReqDto);
    public ResponseEntity<?> totalWorkingHour(PunchRecordReqDto punchRecordReqDto);
    public ResponseEntity<?> previousWeekAttendance(Attendance attendance);

    public ResponseEntity<?> downloadMonthlyAttendance(Attendance attendance) throws IOException;

    public ResponseEntity<?> schedulerForAlert();


}
