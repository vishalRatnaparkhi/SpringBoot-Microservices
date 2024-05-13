package com.spring.rating.services;

import org.springframework.stereotype.Service;
import com.spring.rating.entities.*;
import java.util.List;


public interface RatingService {



        public Rating createRating(Rating rating);

        public List<Rating> getAllRatings();


        public List<Rating> getRatingByHotelId(String id);
        public List<Rating> getRatingsByUserId(String id);



}
