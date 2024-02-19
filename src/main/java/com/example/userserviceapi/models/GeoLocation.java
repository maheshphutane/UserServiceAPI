package com.example.userserviceapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeoLocation extends BaseModel{
    private double latitude;
    private double longitude;
}
