package com.example.userserviceapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpReqDTO {
    private String name;
    private String email;
    private String password;
}
