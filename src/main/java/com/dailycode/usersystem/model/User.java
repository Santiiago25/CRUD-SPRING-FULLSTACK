package com.dailycode.usersystem.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {

    private Long id;

    private String firtsName;

    private String lastName;

    private String email;
}
