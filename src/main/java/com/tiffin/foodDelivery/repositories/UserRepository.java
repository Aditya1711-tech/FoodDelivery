package com.tiffin.foodDelivery.repositories;

import com.tiffin.foodDelivery.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    // Custom query methods can be added here
    Optional<User> findByEmail(String email);

    // Find the user by their ID
    Optional<User> findUserById(String userId);

    // Find only the username by user ID
    @Query(value = "{ '_id': ?0 }", fields = "{ 'name': 1, '_id': 0 }")
    Optional<User> findUsernameByUserId(String userId);
}
