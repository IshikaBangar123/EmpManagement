package com.management.EmpManagement.Service.serviceImpl;

import com.management.EmpManagement.Repo.PartialWFHRepository;
import com.management.EmpManagement.Service.PartialWfhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PartialWFHServiceImpl implements PartialWfhService {

    @Autowired
    private PartialWFHRepository partialWFHRepository;

    @Override
    public ResponseEntity<?> applyForPartial() {
        return null;
    }

    @Override
    public ResponseEntity<?> applyForWfh() {
        return null;
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