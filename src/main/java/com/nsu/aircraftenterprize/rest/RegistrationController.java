package com.nsu.aircraftenterprize.rest;


import com.nsu.aircraftenterprize.entity.RegisteredUser;
import com.nsu.aircraftenterprize.entity.Role;
import com.nsu.aircraftenterprize.exceptions.PasswordAndPasswordConfirmNotEqual;
import com.nsu.aircraftenterprize.exceptions.UserAlreadyExistsException;
import com.nsu.aircraftenterprize.repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.regex.Pattern;

@CrossOrigin( origins = "*", maxAge = 3500)
@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    RegisteredUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    final String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    @PostMapping()
    public ResponseEntity<?> register(@RequestBody RegistrationRequestDTO request) throws UserAlreadyExistsException, PasswordAndPasswordConfirmNotEqual {

        if(!Pattern.compile(regexPattern).matcher(request.getMail()).matches()) {
            return ResponseEntity.badRequest().body("Некорректный формат почты");
        }
        if (userRepository.findByMail(request.getMail()) != null) {
            throw new UserAlreadyExistsException("Пользователь с такой почтой уже существует");
        }
        RegisteredUser user = new RegisteredUser();
        user.setMail(request.getMail());
        if(!request.getPassword().equals(request.getPasswordConfirm())) {
            throw new PasswordAndPasswordConfirmNotEqual("Пароли не совпадают");
        }
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        userRepository.save(user);
        return ResponseEntity.ok("Пользователь зарегистрирован!");
    }
}
