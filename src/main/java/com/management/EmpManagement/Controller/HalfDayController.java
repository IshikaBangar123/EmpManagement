package com.management.EmpManagement.Controller;

import com.management.EmpManagement.Dto.request.HalfDayReqDto;
import com.management.EmpManagement.Dto.request.PartialReqDto;
import com.management.EmpManagement.Service.PartialWfhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/halfDay")
public class HalfDayController {

    @Autowired
    private PartialWfhService partialWFHService;

    @PostMapping("/leave")
    public ResponseEntity<?> applyforleave(@RequestBody HalfDayReqDto halfDayReqDto){
        return  this.partialWFHService.applyForHalfDay(halfDayReqDto);

    }
}
