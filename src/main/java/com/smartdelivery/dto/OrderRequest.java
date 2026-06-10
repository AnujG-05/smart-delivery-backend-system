package com.smartdelivery.dto;

import lombok.Data;

@Data
public class OrderRequest {

    private Long userId;

    private String restaurantName;

    private String deliveryAddress;
}