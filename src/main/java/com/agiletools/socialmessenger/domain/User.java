package com.agiletools.socialmessenger.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Data
@Builder
@Document("Users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String name;

    @Email
    private String email;

    @Length(min = 6)
    private String password;

}
