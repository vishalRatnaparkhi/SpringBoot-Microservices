package com.spring.hotel.services.impl;

import com.spring.hotel.entities.Hotel;
import com.spring.hotel.exceptions.ResourceNotFoundException;
import com.spring.hotel.repositories.HotelRepository;
import com.spring.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelrespo;
    @Override
    public Hotel createHotel(Hotel hotel) {
        hotel.setId(UUID.randomUUID().toString());
        return hotelrespo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelrespo.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelrespo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with given id not found "+id));
    }
}
