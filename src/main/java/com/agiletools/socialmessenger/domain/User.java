package com.agiletools.socialmessenger.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("Users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;

}
