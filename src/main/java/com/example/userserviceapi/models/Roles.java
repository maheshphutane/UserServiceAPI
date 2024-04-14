package com.example.userserviceapi.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Roles extends BaseModel{
    private Long roleId;
    private String name;
}
