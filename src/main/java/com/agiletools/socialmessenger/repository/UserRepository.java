package com.agiletools.socialmessenger.repository;

import com.agiletools.socialmessenger.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, String> {



}
