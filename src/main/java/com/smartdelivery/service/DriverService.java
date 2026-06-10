package com.smartdelivery.service;

import org.springframework.stereotype.Service;

import com.smartdelivery.dto.DriverRequest;
import com.smartdelivery.model.Driver;
import com.smartdelivery.repository.DriverRepository;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver addDriver(DriverRequest request) {

        Driver driver = new Driver();

        driver.setName(request.getName());

        if (request.getAvailable() != null) {
            driver.setAvailable(request.getAvailable());
        }

        return driverRepository.save(driver);
    }
}