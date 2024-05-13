package com.spring.user.repositories;

import com.spring.user.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

public interface UserRepository extends MongoRepository<User, String>
{

}
