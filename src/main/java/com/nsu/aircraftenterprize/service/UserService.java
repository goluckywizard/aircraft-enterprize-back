package com.nsu.aircraftenterprize.service;

import com.nsu.aircraftenterprize.entity.RegisteredUser;
import com.nsu.aircraftenterprize.entity.Role;
import com.nsu.aircraftenterprize.repository.RegisteredUserRepository;
import com.nsu.aircraftenterprize.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    RegisteredUserRepository registeredUserRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        RegisteredUser registeredUser = registeredUserRepository.findByMail(mail);

        if (registeredUser == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return registeredUser;
    }

    public RegisteredUser findUserById(Long userId) {
        Optional<RegisteredUser> userFromDb = registeredUserRepository.findById(userId);
        return userFromDb.orElse(new RegisteredUser());
    }

    public List<RegisteredUser> allUsers() {
        return registeredUserRepository.findAll();
    }

    public boolean saveUser(RegisteredUser user) {
        RegisteredUser userFromDB = registeredUserRepository.findByMail(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        registeredUserRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (registeredUserRepository.findById(userId).isPresent()) {
            registeredUserRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<RegisteredUser> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM RegisteredUser u WHERE u.registered_user_id > :paramId", RegisteredUser.class)
                .setParameter("paramId", idMin).getResultList();
    }
}