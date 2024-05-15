package com.spring.user.impl;

import com.spring.user.entities.Hotel;
import com.spring.user.entities.Rating;
import com.spring.user.entities.User;
import com.spring.user.external.services.HotelService;
import com.spring.user.repositories.UserRepository;
import com.spring.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger= (Logger) LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User saveUser(User user) {
        String randomUserId=UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
         ArrayList<User> users= (ArrayList<User>) userRepository.findAll();
         users.stream().forEach(x-> {
             Rating[] ratings= restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+x.getUserId(), Rating[].class);
             List<Rating> ratingOfUsers=Arrays.stream(ratings).toList();

             ratingOfUsers.forEach(y->{
                 Hotel response =hotelService.getHotel(y.getHotelId());
                 y.setHotel(response);

             });
             x.setRatings(ratingOfUsers);
         });
        return users;
    }

    @Override
    public User getUser(String userId) {
       User user= userRepository.findByUserId(userId);
       Rating[] ratingsOfUser= restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
       List<Rating> ratings= Arrays.stream(ratingsOfUser).toList();
       logger.info("{}",ratings);

        List<Rating>  ratingList = ratings.stream().map(x->{
            Hotel response= hotelService.getHotel(x.getHotelId());
            x.setHotel(response);
            return x;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
       return user;
    }
}
