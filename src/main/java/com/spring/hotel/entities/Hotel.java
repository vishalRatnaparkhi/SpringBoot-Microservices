package com.spring.hotel.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Hotel {

    private  String id;
    private  String name;
    private String location;
    private  String about;
}
