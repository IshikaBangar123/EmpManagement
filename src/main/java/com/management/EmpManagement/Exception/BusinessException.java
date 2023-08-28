package com.management.EmpManagement.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusinessException extends RuntimeException {
    //To make a class Custom Exception  extends RuntimeEXception
    private String errorCode;
    private String errorMessage;

    public BusinessException(int value, String errorMessage) {
    }
}
