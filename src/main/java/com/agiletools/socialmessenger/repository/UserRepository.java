package com.agiletools.socialmessenger.repository;

import com.agiletools.socialmessenger.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, String> {

    public Mono<User> findByEmail(String email);


}
