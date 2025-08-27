package fr.diginamic.demo.service;

import fr.diginamic.demo.entity.UserApp;
import fr.diginamic.demo.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {

    @Autowired
    private UserAppRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    public void createUser(String email, String password) {
        // Encodage du mot de passe
        repo.save(new UserApp(email, encoder.encode(password)));
    }
}