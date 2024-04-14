package com.example.userserviceapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel{
    private String email;
    private String username;
    private String hashedPass;
    @ManyToMany
    private List<Roles> rolesList;
    private Boolean isEmailVerified;

}
