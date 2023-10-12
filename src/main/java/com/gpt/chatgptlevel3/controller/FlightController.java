package com.gpt.chatgptlevel3.controller;

import com.gpt.chatgptlevel3.entity.Flight;
import com.gpt.chatgptlevel3.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<?> getFlight(@PathVariable Long flightId) {
        Optional<Flight> flightOptional = flightService.getFlightById(flightId);
        if (flightOptional.isPresent()) {
            return new ResponseEntity<>(flightOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Flight not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{flightId}/book")
    public ResponseEntity<?> bookFlight(
            @PathVariable Long flightId,
            @RequestParam int numberOfPassengers
    ) {
        Optional<Flight> flightOptional = flightService.bookFlight(flightId, numberOfPassengers);
        if (flightOptional.isPresent()) {
            return new ResponseEntity<>(flightOptional.get(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Flight not found", HttpStatus.NOT_FOUND);
        }
    }
}