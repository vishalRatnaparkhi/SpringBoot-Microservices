package com.spring.hotel.controlers;

import com.spring.hotel.entities.Hotel;
import com.spring.hotel.services.HotelService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping
   public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
       return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel()
    {
        List<Hotel> hotelList= hotelService.getAllHotels();
        return  ResponseEntity.ok(hotelList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById( @PathVariable String id)
    {
        return  ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(id));
    }

}
