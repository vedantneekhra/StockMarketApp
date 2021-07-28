package com.example.apigateway.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UserEntity {

    @Id
    private int id;
    private String userName;
    private String password;
    private String userType;
    private String email;
    private long contactNumber;
    private boolean confirmed;

}
