package com.eloisaoliveira.contentauthoring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eloisaoliveira.contentauthoring.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
