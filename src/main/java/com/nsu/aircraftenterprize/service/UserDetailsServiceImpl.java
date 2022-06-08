package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.RegisteredUser;
import com.nsu.aircraftenterprize.repository.RegisteredUserRepository;
import com.nsu.aircraftenterprize.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {


    private final RegisteredUserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(RegisteredUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        RegisteredUser user = userRepository.findByMail(email);
        if(user == null ) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return SecurityUser.fromUser(user);
    }

    public RegisteredUser findUserByMail(String mail) {
        RegisteredUser user = userRepository.findByMail(mail);
        if(user == null ) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return user;
    }

/*    public Customer findCustomerByUserMail(String mail) {
        RegisteredUser user = userRepository.findByMail(mail);
        if(user == null ) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return user.getCustomer();
    }*/
}