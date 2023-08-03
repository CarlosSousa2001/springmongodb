package com.spingmongo.mongodb.config;

import com.spingmongo.mongodb.domain.Post;
import com.spingmongo.mongodb.domain.User;
import com.spingmongo.mongodb.dto.AuthorDto;
import com.spingmongo.mongodb.repository.PostRepository;
import com.spingmongo.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    private UserRepository userRepository;
    private PostRepository postRepository;
    @Autowired
    public Instantiation(@Qualifier("userRepository") UserRepository userRepository,
                         @Qualifier("postRepository") PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob ));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para são paulo", new AuthorDto(maria));
        Post post2 = new Post(null, sdf.parse("25/08/2023"), "Partiu slz", "Vou viajar para o Maranhão", new AuthorDto(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
