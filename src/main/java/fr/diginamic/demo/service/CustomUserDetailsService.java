package fr.diginamic.demo.service;

import fr.diginamic.demo.entity.UserApp;
import fr.diginamic.demo.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAppRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    /** Permet de créer un utilisateur (inscription) */
    public void createUser(String email, String password) {
        repo.save(new UserApp(email, encoder.encode(password)));
    }

    /** Méthode utilisée par Spring Security pour l’authentification */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserApp user = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé : " + email));

        // Conversion vers UserDetails de Spring Security
        return User.withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities("USER") // ou gérer des rôles plus tard
                .build();
    }
}