package com.heavymaverick.sprsecdemo.models;


import jakarta.persistence.*;
import lombok.Data;
// маппинг в таблице
@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

}
