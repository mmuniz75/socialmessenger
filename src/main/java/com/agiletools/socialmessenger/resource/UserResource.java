package com.agiletools.socialmessenger.resource;

import com.agiletools.socialmessenger.domain.User;
import com.agiletools.socialmessenger.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@RestController
public class UserResource {

    private final UserRepository repository;

    public UserResource(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<User> listUsers() {
        return repository.findAll();
    }

    @PostMapping(path = "/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> addUser(@RequestBody @Valid User user) {
        return repository.save(user);
    }
}
