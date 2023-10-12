package com.gpt.chatgptlevel3.service;

import com.gpt.chatgptlevel3.entity.RentalCar;
import com.gpt.chatgptlevel3.repository.RentalCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RentalCarService {
    @Autowired
    private RentalCarRepository rentalCarRepository;

    public List<RentalCar> getAllRentalCars() {
        return rentalCarRepository.findAll();
    }

    public Optional<RentalCar> getRentalCarById(Long carId) {
        return rentalCarRepository.findById(carId);
    }

    public Optional<RentalCar> rentCar(Long carId, int numberOfCars, Date startDate, Date endDate) {
        Optional<RentalCar> car = getRentalCarById(carId);
        // Implement car rental logic here, e.g., check car availability, create rental record, etc.
        // You may want to interact with other services or components for this.
        return car;
    }
}