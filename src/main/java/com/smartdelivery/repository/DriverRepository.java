package com.smartdelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartdelivery.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findByIsAvailableTrue();

}