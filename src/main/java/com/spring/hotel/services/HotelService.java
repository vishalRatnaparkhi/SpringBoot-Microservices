package com.spring.hotel.services;

import com.spring.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {


   public Hotel createHotel(Hotel hotel);

    public List<Hotel> getAllHotels();


    public Hotel getHotelById(String id);


}
