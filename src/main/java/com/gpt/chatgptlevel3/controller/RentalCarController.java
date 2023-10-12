package com.gpt.chatgptlevel3.controller;

import com.gpt.chatgptlevel3.entity.RentalCar;
import com.gpt.chatgptlevel3.service.RentalCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class RentalCarController {
    @Autowired
    private RentalCarService rentalCarService;

    @GetMapping
    public ResponseEntity<List<RentalCar>> getAllRentalCars() {
        List<RentalCar> cars = rentalCarService.getAllRentalCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<?> getRentalCar(@PathVariable Long carId) {
        Optional<RentalCar> carOptional = rentalCarService.getRentalCarById(carId);
        if (carOptional.isPresent()) {
            return new ResponseEntity<>(carOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Rental car not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{carId}/rent")
    public ResponseEntity<?> rentCar(
            @PathVariable Long carId,
            @RequestParam int numberOfCars,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ) {
        Optional<RentalCar> carOptional = rentalCarService.rentCar(carId, numberOfCars, startDate, endDate);
        if (carOptional.isPresent()) {
            return new ResponseEntity<>(carOptional.get(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Rental car not found", HttpStatus.NOT_FOUND);
        }
    }
}