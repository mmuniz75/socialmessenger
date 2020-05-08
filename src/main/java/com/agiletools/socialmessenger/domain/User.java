package com.agiletools.socialmessenger.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("_user")
public class User {

    @Id
    private String id;

    @NotEmpty
    private String name;

    @Email
    @NotEmpty
    private String email;

    @Length(min = 6)
    @NotEmpty
    private String password;

}
