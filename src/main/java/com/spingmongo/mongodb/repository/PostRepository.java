package com.spingmongo.mongodb.repository;

import com.spingmongo.mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String txt);
}
