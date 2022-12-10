package com.example.checklist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "username")
    @JsonProperty("username")
    private String userName;

    @Column(name = "password")
    @JsonProperty("password")
    private String password;
}
