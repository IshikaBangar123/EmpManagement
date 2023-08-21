package com.management.EmpManagement.Advice;

import com.management.EmpManagement.Exception.BusinessException;
import com.management.EmpManagement.Exception.EmptyInputException;
import com.management.EmpManagement.Util.Message;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handlerEmptyInput(EmptyInputException emptyInputException) {
        return new ResponseEntity<String>(Message.EMPTY_FIELD, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<String> handlerNoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<String>(Message.FIELD_NOT_EXITS_DB, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<String> handlerBusinessException(BusinessException BusinessException) {
        return new ResponseEntity<String>(Message.BOOKING_NAME_NOT_EXITS_DB, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public ResponseEntity<String> handlerEmptyResultDataAccessException(EmptyResultDataAccessException emptyResultDataAccessException) {
        return new ResponseEntity<String>(Message.FIELD_NOT_EXITS_DB_DELETE, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IllegalStateException.class)
    public ResponseEntity<String> handlerIllegalStateException(IllegalStateException IllegalStateException) {
        return new ResponseEntity<String>(Message.FIELD_NOT_EXITS_DB_UPDATE, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<String> handlerHttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException) {
        return new ResponseEntity<String>(Message.BOOKING_NAME_NOT_EXITS_DB, HttpStatus.NOT_FOUND);
    }
}
