package com.spring.hotel.repositories;

import com.spring.hotel.entities.Hotel;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<Hotel, String> {
}
