package com.example.userserviceapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel{
    private String email;
    private String username;
    private Name name;
    private Address address;
    private String phone;
}
