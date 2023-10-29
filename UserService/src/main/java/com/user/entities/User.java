package com.user.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "users")
public class User {

	@Id
    private String userId;

    private String username;
    private String email;
    private String password;

    // Additional user details
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
