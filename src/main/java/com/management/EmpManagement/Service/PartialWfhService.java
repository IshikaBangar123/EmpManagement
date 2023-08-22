package com.management.EmpManagement.Service;

import org.springframework.http.ResponseEntity;

public interface PartialWfhService {


    public ResponseEntity<?> applyForPartial();

    public ResponseEntity<?> applyForWfh();

/*
    public ResponseEntity<?> viewLeaveById(Long pwId);

    public ResponseEntity<?> viewAllLeave();*/
}
