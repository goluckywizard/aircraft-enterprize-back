package com.nsu.aircraftenterprize.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PasswordResetToken {
    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = RegisteredUser.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private RegisteredUser user;

    private Date expiryDate;
}
