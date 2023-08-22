package com.management.EmpManagement.Enum;

public enum Status {

    HALF_DAY("HalfDay"), PARTIAL_DAY("PartialDay"),
    WORK_FROM_HOME("WorkFromHome"),
   ;

    private String status;

    // getter method
    public String getStatus() {
        return this.status;
    }

    // enum constructor - cannot be public or protected
    private Status(String status) {
        this.status = status;
    }
}

