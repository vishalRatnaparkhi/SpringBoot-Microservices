package com.spring.rating.services.impl;
import com.spring.rating.entities.Rating;
import com.spring.rating.repository.RatingRepoitory;
import com.spring.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepoitory ratingRepoitory;
    @Override
    public Rating createRating(Rating rating) {
        return ratingRepoitory.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepoitory.findAll();
    }

    @Override
    public List<Rating> getRatingByHotelId(String id) {
        return ratingRepoitory.findByHotelId(id);
    }

    @Override
    public List<Rating> getRatingsByUserId(String id) {
        return ratingRepoitory.findByUserId(id);
    }
}
