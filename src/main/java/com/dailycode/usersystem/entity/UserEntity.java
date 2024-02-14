package com.dailycode.usersystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombres")
    private String firtsName;

    @Column(name = "apellidos")
    private String lastName;

    @Column(name = "email", unique = true) //unique = registro unico
    private String email;


}
