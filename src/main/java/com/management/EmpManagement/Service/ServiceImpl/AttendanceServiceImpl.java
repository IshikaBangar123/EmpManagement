package com.management.EmpManagement.Service.ServiceImpl;

import com.management.EmpManagement.Dto.request.CheckInReqDto;
import com.management.EmpManagement.Dto.request.CheckOutReqDto;
import com.management.EmpManagement.Dto.request.PunchRecordReqDto;
import com.management.EmpManagement.Dto.response.CheckInResDto;
import com.management.EmpManagement.Dto.response.CheckOutResDto;
import com.management.EmpManagement.Entity.Attendance;
import com.management.EmpManagement.Entity.EmployeeEntity;
import com.management.EmpManagement.Enum.Action;
import com.management.EmpManagement.Repo.EmployeeRepo;
import com.management.EmpManagement.Repo.AttendanceRepository;
import com.management.EmpManagement.Service.AttendanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.*;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepo employeeRe;


    public ResponseEntity<?> checkInTime(CheckInReqDto checkInReqDto) {
        Attendance map = this.modelMapper.map(checkInReqDto, Attendance.class);
        final Optional<EmployeeEntity> byId = employeeRe.findByEmpId(String.valueOf(checkInReqDto.getEmpId()));
        if (byId.isPresent()) {
            map.setInDuration(LocalTime.now());
            map.setPunchDate(LocalDate.now());
            map.setEmployee(byId.get());
            Attendance save = this.attendanceRepository.save(map);
            CheckInResDto map1 = this.modelMapper.map(save, CheckInResDto.class);
            map1.setEmpId(save.getEmployee().getEmpId());
            return new ResponseEntity<>(map1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee Id Not Found", HttpStatus.OK);
        }
    }


    @Override
    public ResponseEntity<?> checkOutTime(CheckOutReqDto checkOutReqDto) {
        Attendance map = this.modelMapper.map(checkOutReqDto, Attendance.class);
        final Optional<EmployeeEntity> byId = employeeRe.findByEmpId(String.valueOf(checkOutReqDto.getEmpId()));
        if (byId.isPresent()) {
            map.setOutDuration(LocalTime.now());
            map.setPunchDate(LocalDate.now());
            map.setEmployee(byId.get());
            Attendance save = this.attendanceRepository.save(map);
            CheckOutResDto map1 = this.modelMapper.map(save, CheckOutResDto.class);
            map1.setEmpId(save.getEmployee().getEmpId());
            return new ResponseEntity<>(map1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Employee Id Not Found", HttpStatus.OK);
        }
    }

    @Override
        public ResponseEntity<?> totalWorkingHour(PunchRecordReqDto punchRecordReqDto) {
            Optional<EmployeeEntity> employeeOptional = employeeRe.findByEmpId(String.valueOf(punchRecordReqDto.getEmpId()));

            if (employeeOptional.isPresent()) {
                List<Attendance> attendanceRecords = attendanceRepository.
                        findByEmployeeEmpIdAndPunchDate(
                        punchRecordReqDto.getEmpId(), punchRecordReqDto.getPunchDate());

                long totalMinutes = 0;

                LocalTime lastPunchIn = null;
                LocalTime lastPunchOut = null;

                for (Attendance attendance : attendanceRecords) {
                    if (attendance.getPunchAction() == Action.CHECK_IN) {
                        lastPunchIn = attendance.getInDuration();
                        if (lastPunchOut != null) {
                            Duration duration = Duration.between(lastPunchOut, lastPunchIn);
                            totalMinutes += duration.toMinutes();
                        }
                    } else if (attendance.getPunchAction() == Action.CHECK_OUT) {
                        lastPunchOut = attendance.getOutDuration();
                        if (lastPunchIn != null) {
                            Duration duration = Duration.between(lastPunchIn, lastPunchOut);
                            totalMinutes += duration.toMinutes();
                        }
                    }
                }


                long totalHours = totalMinutes / 60;
                long remainingMinutes = totalMinutes % 60;

                return new ResponseEntity<>(totalHours + " hours " + remainingMinutes + " minutes", HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        }



    /*public ResponseEntity<?> totalWorkingHour(PunchRecordReqDto punchRecordReqDto) {
        Optional<EmployeeEntity> employeeOptional = employeeRe.findByEmpId(String.valueOf(punchRecordReqDto.getEmpId()));


            if (employeeOptional.isPresent()) {
                List<Attendance> attendanceRecords = attendanceRepository.findByEmployeeEmpId(punchRecordReqDto.getEmpId());

                long totalMinutes = 0;

                LocalTime lastPunchIn = null;
                LocalTime lastPunchOut = null;

                for (Attendance attendance : attendanceRecords) {
                    if (attendance.getPunchAction() == Action.CHECK_IN) {
                        lastPunchIn = attendance.getInDuration();
                        if (lastPunchOut != null) {
                            Duration duration = Duration.between(lastPunchOut, lastPunchIn);
                            totalMinutes += duration.toMinutes();
                        }
                    } else if (attendance.getPunchAction() == Action.CHECK_OUT) {
                        lastPunchOut = attendance.getOutDuration();
                        if (lastPunchIn != null) {
                            Duration duration = Duration.between(lastPunchIn, lastPunchOut);
                            totalMinutes += duration.toMinutes();
                        }
                    }
                }

                // Calculate hours and minutes from totalMinutes
                long totalHours = totalMinutes / 60;
                long remainingMinutes = totalMinutes % 60;

                return new ResponseEntity<>(totalHours + " hours " + remainingMinutes + " minutes", HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }


        }


*/

    @Override
    public ResponseEntity<?> downloadMonthlyAttendance(Attendance attendance) throws IOException {
      return  null;
    }



    @Override
    public ResponseEntity<?> schedulerForAlert() {
        return null;
    }
    @Override
    public ResponseEntity<?> previousWeekAttendance(Attendance attendance) {
        return null;
    }
}