package com.agiletools.socialmessenger.service;

import com.agiletools.socialmessenger.domain.User;
import com.agiletools.socialmessenger.exception.APIException;
import com.agiletools.socialmessenger.exception.ConflictException;
import com.agiletools.socialmessenger.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@Service
@RequiredArgsConstructor
public class UserService {

    private static final String EMAIL_ALREADY_EXISTS = "Email já está cadastrado";
    private static final String EMAIL_NOT_FOUND = "%s não cadastrado";

    private final UserRepository repository;

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
                        return Mono.error(new ConflictException(EMAIL_ALREADY_EXISTS));
                })
                ;

    }

}
