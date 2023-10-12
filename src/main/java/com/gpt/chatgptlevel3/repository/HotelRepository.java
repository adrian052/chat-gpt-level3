package com.gpt.chatgptlevel3.repository;

import com.gpt.chatgptlevel3.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // Custom query methods can be defined here
}