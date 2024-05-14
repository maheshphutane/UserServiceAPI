package com.example.userserviceapi.security.models;

import com.example.userserviceapi.models.Roles;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.GrantedAuthority;
@JsonDeserialize
public class CustomGrantedAuthority implements GrantedAuthority {
    private Roles role;
    private String authority;
    public CustomGrantedAuthority() {
    }
    public CustomGrantedAuthority(Roles role) {
        this.role = role;
        this.authority = role.getName();
    }
    @Override
    public String getAuthority() {
        return authority;
    }
}
