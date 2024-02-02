package com.ToDoApplication.ToDoApplication.model;


import jakarta.persistence.*;
import lombok.Data;

import java.net.PasswordAuthentication;
import java.text.DateFormat;

@Data
@Entity
@Table(name = "User_list")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String full_name;
    private String  position;
    private String email;
    private String password;
    @Lob
    private byte[] image;

//    Getters and Setters
}
