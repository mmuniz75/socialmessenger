package com.agiletools.socialmessenger.service;

import com.agiletools.socialmessenger.domain.User;
import com.agiletools.socialmessenger.exception.APIException;
import com.agiletools.socialmessenger.exception.ConflictException;
import com.agiletools.socialmessenger.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@Service
public class UserService {

    private static final String EMAIL_ALREADY_EXISTS = "%s já está cadastrado";

    private final UserRepository repository;

    public UserService(UserRepository repository){

        this.repository = repository;
    }

    public Flux<User> listUsers() {

        return repository.findAll();
    }

    public Mono<User> addUser(@RequestBody @Valid User user) throws APIException {

        return repository.findByEmail(user.getEmail())
                        .hasElement()
                        .flatMap(userExits -> {
                            if (!userExits.booleanValue())
                                return repository.save(user);
                            else
                                return Mono.error(new ConflictException(String.format(EMAIL_ALREADY_EXISTS,user.getEmail())));
                        })
                        ;

    }
}
