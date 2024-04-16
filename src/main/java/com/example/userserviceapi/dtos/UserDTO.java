package com.example.userserviceapi.dtos;

import com.example.userserviceapi.models.Roles;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class UserDTO {
    private String email;
    private String username;
    private String hashedPass;
    private List<Roles> rolesList;
    private Boolean isEmailVerified;
}
