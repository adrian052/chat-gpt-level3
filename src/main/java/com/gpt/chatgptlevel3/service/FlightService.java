package com.gpt.chatgptlevel3.service;

import com.gpt.chatgptlevel3.entity.Flight;
import com.gpt.chatgptlevel3.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long flightId) {
        return flightRepository.findById(flightId);
    }

    public Optional<Flight> bookFlight(Long flightId, int numberOfPassengers) {
        Optional<Flight> flight = getFlightById(flightId);
        // Implement booking logic here, e.g., check availability, create booking record, etc.
        // You may want to interact with other services or components for this.
        return flight;
    }
}


