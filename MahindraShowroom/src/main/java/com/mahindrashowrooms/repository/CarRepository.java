package com.mahindrashowrooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahindrashowrooms.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
