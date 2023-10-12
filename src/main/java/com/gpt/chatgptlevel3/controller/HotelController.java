package com.gpt.chatgptlevel3.controller;

import com.gpt.chatgptlevel3.entity.Hotel;
import com.gpt.chatgptlevel3.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<?> getHotel(@PathVariable Long hotelId) {
        Optional<Hotel> hotelOptional = hotelService.getHotelById(hotelId);
        if (hotelOptional.isPresent()) {
            return new ResponseEntity<>(hotelOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Hotel not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{hotelId}/book")
    public ResponseEntity<?> bookHotel(
            @PathVariable Long hotelId,
            @RequestParam int numberOfRooms,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkInDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkOutDate
    ) {
        Optional<Hotel> hotelOptional = hotelService.bookHotel(hotelId, numberOfRooms, checkInDate, checkOutDate);
        if (hotelOptional.isPresent()) {
            return new ResponseEntity<>(hotelOptional.get(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Hotel not found", HttpStatus.NOT_FOUND);
        }
    }
}
