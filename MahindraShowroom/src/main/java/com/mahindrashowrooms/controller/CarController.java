package com.mahindrashowrooms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mahindrashowrooms.service.CarService;



@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/view-all-cars")
    public String viewAllCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "view-all-cars";
    }
}

