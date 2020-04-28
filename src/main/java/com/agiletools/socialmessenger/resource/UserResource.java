package com.agiletools.socialmessenger.resource;

import com.agiletools.socialmessenger.domain.User;
import com.agiletools.socialmessenger.exception.APIException;
import com.agiletools.socialmessenger.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@RestController
public class UserResource {

    private final UserService service;

    public UserResource(UserService service){

        this.service= service;
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<User> listUsers() {

        return service.listUsers();
    }

    @PostMapping(path = "/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> addUser(@RequestBody @Valid User user) throws APIException {

        return service.addUser(user);
    }
}
