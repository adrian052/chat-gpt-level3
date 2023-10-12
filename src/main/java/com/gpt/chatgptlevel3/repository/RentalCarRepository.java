package com.gpt.chatgptlevel3.repository;

import com.gpt.chatgptlevel3.entity.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalCarRepository extends JpaRepository<RentalCar, Long> {
    // Custom query methods can be defined here
}