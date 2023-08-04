package com.spingmongo.mongodb.service;

import com.spingmongo.mongodb.domain.Post;
import com.spingmongo.mongodb.domain.User;
import com.spingmongo.mongodb.dto.UserDTO;
import com.spingmongo.mongodb.repository.PostRepository;
import com.spingmongo.mongodb.repository.UserRepository;
import com.spingmongo.mongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> isPost = postRepository.findById(id);
        if (isPost.isPresent()) {
            return isPost.get();
        } else {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
    }

}
