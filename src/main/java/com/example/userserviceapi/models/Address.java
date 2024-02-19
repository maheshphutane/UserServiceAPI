package com.example.userserviceapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address extends BaseModel{
    private String city;
    private String street;
    private GeoLocation geolocation;
}
