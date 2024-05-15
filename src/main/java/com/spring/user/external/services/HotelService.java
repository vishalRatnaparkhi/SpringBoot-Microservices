package com.spring.user.external.services;

import com.spring.user.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTELSERVICE")
public interface HotelService {

    @GetMapping("/hotels/{hotelId}")
     Hotel getHotel(@PathVariable String hotelId);
}
