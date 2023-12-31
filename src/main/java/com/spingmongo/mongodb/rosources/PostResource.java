package com.spingmongo.mongodb.rosources;

import com.spingmongo.mongodb.domain.Post;
import com.spingmongo.mongodb.domain.User;
import com.spingmongo.mongodb.dto.UserDTO;
import com.spingmongo.mongodb.rosources.util.URL;
import com.spingmongo.mongodb.service.PostService;
import com.spingmongo.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
       Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findBytext(@RequestParam(value = "text", defaultValue = "") String text) throws UnsupportedEncodingException {
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
