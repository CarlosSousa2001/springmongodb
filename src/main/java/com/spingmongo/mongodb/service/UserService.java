package com.spingmongo.mongodb.service;

import com.spingmongo.mongodb.domain.User;
import com.spingmongo.mongodb.dto.UserDTO;
import com.spingmongo.mongodb.repository.UserRepository;
import com.spingmongo.mongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(String id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
    }
    public User insert(User obj){
        return userRepository.insert(obj);
    }
    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
