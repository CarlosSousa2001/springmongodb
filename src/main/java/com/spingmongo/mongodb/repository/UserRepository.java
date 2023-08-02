package com.spingmongo.mongodb.repository;

import com.spingmongo.mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
