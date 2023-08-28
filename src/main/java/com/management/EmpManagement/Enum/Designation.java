package com.management.EmpManagement.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Designation {

    HEAD_HR("Head_Hr"),
    HR("Hr"),
    JR_JAVA_DEVELOPER("Jr_Java_Developer"),
    SR_JAVA_DEVELOPER("Sr_Java_Develpoer"),
    JR_REACT_DEVLOPER("Jr_React_Developer"),
    SR_REACT_DEVELOPER("Sr_React_Developer"),
    JR_PHP_DEVELOPER("Jr_Php_Developer"),
    SR_PHP_DEVELOPER("Sr_Php_Developer"),
    JR_ANDROID_DEVELOPER("Jr_Android_Developer"),
    SR_ANDROID_DEVELOPER("Jr_Android_Developer"),
    SALES("Sales");

    private String Designation;

}
