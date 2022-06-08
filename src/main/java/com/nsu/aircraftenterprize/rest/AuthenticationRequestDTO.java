package com.nsu.aircraftenterprize.rest;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    private String mail;
    private String password;
}