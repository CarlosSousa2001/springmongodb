package com.spingmongo.mongodb.rosources;

import com.spingmongo.mongodb.domain.User;
import com.spingmongo.mongodb.dto.UserDTO;
import com.spingmongo.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UseResource {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList())  ;
        return ResponseEntity.ok().body(listDto);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
        User obj = userService.fromDTO(objDto);
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().header("message","Usuário deletado").build();
    }
    
}
