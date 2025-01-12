package com.alura.challenge.foro_hub.controller;

import com.alura.challenge.foro_hub.domain.DataResponseJson;
import com.alura.challenge.foro_hub.domain.user.User;
import com.alura.challenge.foro_hub.domain.user.UsersRepository;
import com.alura.challenge.foro_hub.domain.user.dto.DataResponseUser;
import com.alura.challenge.foro_hub.domain.user.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping
    public ResponseEntity<DataResponseJson> createNewUser(@RequestBody @Valid UserDTO userDTO, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("******"+userDTO+"*****");
        User user = usersRepository.save(new User(userDTO));
        DataResponseUser dataResponseUser = new DataResponseUser(user.getId(), user.getNames(), user.getEmail(), user.getPassword(), user.getProfile());
        DataResponseJson dataResponseJson = new DataResponseJson("User created succesfully",dataResponseUser);
        URI url = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(url).body(dataResponseJson);
    }
}
