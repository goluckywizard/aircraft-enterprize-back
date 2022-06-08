package com.nsu.aircraftenterprize.repository;

import com.nsu.aircraftenterprize.entity.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {
    RegisteredUser findByMail(String mail);
}
