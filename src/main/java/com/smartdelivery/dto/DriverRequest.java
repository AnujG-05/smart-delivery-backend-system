package com.smartdelivery.dto;

import lombok.Data;

@Data
public class DriverRequest {

    private String name;

    private Boolean available = true;
}