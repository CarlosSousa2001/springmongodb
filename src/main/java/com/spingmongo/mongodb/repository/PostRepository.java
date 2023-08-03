package com.spingmongo.mongodb.repository;

import com.spingmongo.mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
