package com.gpt.chatgptlevel3.repository;

import com.gpt.chatgptlevel3.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    // Custom query methods can be defined here
}