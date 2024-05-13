package com.spring.rating.controller;

import com.spring.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.rating.entities.*;
import java.util.List;


@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping
    public  ResponseEntity<Rating> createRating( @RequestBody  Rating rating)
    {
        Rating r= ratingService.createRating(rating);
        return new ResponseEntity<Rating>(r, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<Rating>> getAllRating()
    {
        return  ResponseEntity.ok(ratingService.getAllRatings());
    }
    @GetMapping("users/{userId}")
    public  ResponseEntity<List<Rating>> getRatingByUserId( @PathVariable  String userId)
    {
        return  ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }

    @GetMapping("hotels/{hotelId}")
    public  ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable  String hotelId)
    {
        return  ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }
}

