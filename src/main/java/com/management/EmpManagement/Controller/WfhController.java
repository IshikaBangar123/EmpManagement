package com.management.EmpManagement.Controller;

import com.management.EmpManagement.Dto.request.WorkFromHomeReqDto;
import com.management.EmpManagement.Service.PartialWfhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wfh")
public class WfhController {
    @Autowired
    private PartialWfhService partialWFHService;

    @PostMapping("/leave")
    public ResponseEntity<?> applyforleave(@RequestBody WorkFromHomeReqDto workFromHomeReqDto){
        return  this.partialWFHService.applyForWfh(workFromHomeReqDto);

    }
}
