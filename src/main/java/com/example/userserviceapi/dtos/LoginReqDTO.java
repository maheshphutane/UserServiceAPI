package com.example.userserviceapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReqDTO {
    private String email;
    private String password;
}
