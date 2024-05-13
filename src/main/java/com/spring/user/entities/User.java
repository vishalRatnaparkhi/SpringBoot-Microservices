package com.spring.user.entities;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter


public class User {

    private String userId;

    private  String name;
    private  String email;

    private  String about;


    private List<Rating> ratings= new ArrayList<>();


}
