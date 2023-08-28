package com.management.EmpManagement.Enum;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;



public enum Action {
    @JsonProperty("CheckIn")
    CHECK_IN,

    @JsonProperty("CheckOut")
    CHECK_OUT
}

