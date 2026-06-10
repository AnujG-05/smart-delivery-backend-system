package com.smartdelivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderStatsResponse {

    private long totalOrders;
    private long deliveredOrders;
    private long cancelledOrders;
    private long activeOrders;
}