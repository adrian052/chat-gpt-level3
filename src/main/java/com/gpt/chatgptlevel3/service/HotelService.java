package com.gpt.chatgptlevel3.service;

import com.gpt.chatgptlevel3.entity.Hotel;
import com.gpt.chatgptlevel3.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId);
    }

    public Optional<Hotel> bookHotel(Long hotelId, int numberOfRooms, Date checkInDate, Date checkOutDate) {
        Optional<Hotel> hotel = getHotelById(hotelId);
        // Implement booking logic here, e.g., check room availability, create booking record, etc.
        // You may want to interact with other services or components for this.
        return hotel;
    }
}
