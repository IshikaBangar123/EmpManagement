package com.management.EmpManagement.Service;

import com.management.EmpManagement.Dto.request.HalfDayReqDto;
import com.management.EmpManagement.Dto.request.PartialReqDto;
import com.management.EmpManagement.Dto.request.WorkFromHomeReqDto;
import org.springframework.http.ResponseEntity;

public interface PartialWfhService {


    public ResponseEntity<?> applyForPartial(PartialReqDto partialReqDto);

    public ResponseEntity<?> applyForWfh(WorkFromHomeReqDto workFromHomeReqDto);
    public ResponseEntity<?> applyForHalfDay(HalfDayReqDto halfDayReqDto);

/*
    public ResponseEntity<?> viewLeaveById(Long pwId);

    public ResponseEntity<?> viewAllLeave();*/
}
