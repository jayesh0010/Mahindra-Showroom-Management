package com.mahindrashowrooms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mahindrashowrooms.model.TestDriveBooking;
import com.mahindrashowrooms.service.TestDriveBookingService;

@Controller
public class TestDriveBookingController {
    @Autowired
    private TestDriveBookingService testDriveBookingService;

    @GetMapping("/book-test-drive")
    public String bookTestDrive() {
        return "book-test-drive";
    }

    @PostMapping("/submit-booking")
    public String submitBooking(@ModelAttribute TestDriveBooking booking, Model model) {
        TestDriveBooking savedBooking = testDriveBookingService.saveTestDriveBooking(booking);
        model.addAttribute("booking", savedBooking);
        return "confirmation";
    }
}
