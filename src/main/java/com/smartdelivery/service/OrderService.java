package com.smartdelivery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartdelivery.dto.OrderRequest;
import com.smartdelivery.dto.OrderStatsResponse;
import com.smartdelivery.exception.DriverUnavailableException;
import com.smartdelivery.exception.OrderNotFoundException;
import com.smartdelivery.model.Driver;
import com.smartdelivery.model.Order;
import com.smartdelivery.model.OrderStatus;
import com.smartdelivery.repository.DriverRepository;
import com.smartdelivery.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepo;
    private final DriverRepository driverRepo;

    public OrderService(OrderRepository orderRepo,
                        DriverRepository driverRepo) {
        this.orderRepo = orderRepo;
        this.driverRepo = driverRepo;
    }

    // ✅ Updated to use OrderRequest DTO
    public Order placeOrder(OrderRequest request) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setRestaurantName(request.getRestaurantName());
        order.setDeliveryAddress(request.getDeliveryAddress());

       List<Driver> drivers = driverRepo.findByIsAvailableTrue();

    // ✅ Throw exception if no drivers available
    if (drivers.isEmpty()) {
        throw new DriverUnavailableException("No drivers available currently");
    }

    // ✅ Otherwise assign the first available driver
    Driver driver = drivers.get(0);
    order.setDriverId(driver.getId());
    driver.setAvailable(false);
    driverRepo.save(driver);

    order.setStatus(OrderStatus.PLACED);
    return orderRepo.save(order);
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepo.findByUserId(userId);
    }

    public Order updateStatus(Long orderId, OrderStatus status) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        order.setStatus(status);

        if ((status == OrderStatus.DELIVERED || status == OrderStatus.CANCELLED)
                && order.getDriverId() != null) {
            Driver driver = driverRepo.findById(order.getDriverId())
                    .orElseThrow(() -> new RuntimeException("Driver not found"));
            driver.setAvailable(true);
            driverRepo.save(driver);
        }

        return orderRepo.save(order);
    }

    // ✅ Statistics method remains unchanged
    public OrderStatsResponse getStats() {
        long totalOrders = orderRepo.count();
        long deliveredOrders = orderRepo.countByStatus(OrderStatus.DELIVERED);
        long cancelledOrders = orderRepo.countByStatus(OrderStatus.CANCELLED);
        long activeOrders = totalOrders - deliveredOrders - cancelledOrders;

        return new OrderStatsResponse(
                totalOrders,
                deliveredOrders,
                cancelledOrders,
                activeOrders
        );
    }
}
