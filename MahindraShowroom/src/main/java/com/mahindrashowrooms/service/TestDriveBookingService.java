package com.mahindrashowrooms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahindrashowrooms.model.TestDriveBooking;
import com.mahindrashowrooms.repository.TestDriveBookingRepository;

@Service
public class TestDriveBookingService {
    @Autowired
    private TestDriveBookingRepository testDriveBookingRepository;

    public TestDriveBooking saveTestDriveBooking(TestDriveBooking booking) {
        return testDriveBookingRepository.save(booking);
    }
}
