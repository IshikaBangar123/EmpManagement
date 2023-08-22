package com.management.EmpManagement.Service.serviceImpl;

import com.management.EmpManagement.Dto.request.HalfDayReqDto;
import com.management.EmpManagement.Dto.request.PartialReqDto;
import com.management.EmpManagement.Dto.request.WorkFromHomeReqDto;
import com.management.EmpManagement.Dto.response.HalfDayResDto;
import com.management.EmpManagement.Dto.response.PartialResDto;
import com.management.EmpManagement.Dto.response.WorkFromHomeResDto;
import com.management.EmpManagement.Entity.PartialWorkFromHome;
import com.management.EmpManagement.Repo.PartialWFHRepository;
import com.management.EmpManagement.Service.PartialWfhService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PartialWFHServiceImpl implements PartialWfhService {

    @Autowired
    private PartialWFHRepository partialWFHRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<?> applyForPartial(PartialReqDto partialReqDto) {
        PartialWorkFromHome map = this.modelMapper.map(partialReqDto, PartialWorkFromHome.class);
         PartialWorkFromHome save = this.partialWFHRepository.save(map);
        PartialResDto map1 = this.modelMapper.map(save, PartialResDto.class);
        return new ResponseEntity<>(map1, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> applyForWfh(WorkFromHomeReqDto workFromHomeReqDto) {
     PartialWorkFromHome map = this.modelMapper.map(workFromHomeReqDto, PartialWorkFromHome.class);
        PartialWorkFromHome save = this.partialWFHRepository.save(map);
        WorkFromHomeResDto map1 = this.modelMapper.map(save, WorkFromHomeResDto.class);
        return new ResponseEntity<>(map1, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> applyForHalfDay(HalfDayReqDto halfDayReqDto) {
        PartialWorkFromHome map = this.modelMapper.map(halfDayReqDto, PartialWorkFromHome.class);
        PartialWorkFromHome save = this.partialWFHRepository.save(map);
        HalfDayResDto map1 = this.modelMapper.map(save, HalfDayResDto.class);
        return new ResponseEntity<>(map1, HttpStatus.OK);
    }

 /*   @Override
    public ResponseEntity<?> viewLeaveById(Long pwId) {
        return null;
    }

    @Override
    public ResponseEntity<?> viewAllLeave() {
        return null;
    }
*/
}