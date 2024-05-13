package com.spring.rating.repository;

import com.spring.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepoitory extends MongoRepository<Rating, String> {
    List<Rating> findByUserId(String userid);
    List<Rating> findByHotelId(String userid);
}
