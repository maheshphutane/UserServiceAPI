package com.example.userserviceapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Name extends BaseModel{
    private String firstname;
    private String lastname;
}
