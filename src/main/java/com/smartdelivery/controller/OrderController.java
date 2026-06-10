package com.smartdelivery.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartdelivery.dto.OrderRequest;
import com.smartdelivery.dto.OrderStatsResponse;
import com.smartdelivery.model.Order;
import com.smartdelivery.model.OrderStatus;
import com.smartdelivery.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
public Order placeOrder(@RequestBody OrderRequest request) {

    return orderService.placeOrder(request);
}

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(
            @PathVariable Long id,
            @RequestParam OrderStatus status) {
        return orderService.updateStatus(id, status);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/stats")
    public OrderStatsResponse getStats() {
        return orderService.getStats();
    }
}
