package com.spring.user.repositories;

import com.spring.user.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String>
{
    User findByUserId(String userid);
}
