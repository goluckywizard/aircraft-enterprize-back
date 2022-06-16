package com.nsu.aircraftenterprize.rest;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    String token;
    String password;
}
