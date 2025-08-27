package fr.diginamic.demo;

import fr.diginamic.demo.UserApp;
import fr.diginamic.demo.UserAppRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserAppRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserAppRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Supprime tous les anciens utilisateurs pour test propre
        userRepo.deleteAll();

        // Création de nouveaux users avec mot de passe encodé
        userRepo.save(new UserApp("laurence@example.com", passwordEncoder.encode("1234")));
        userRepo.save(new UserApp("alice@example.com", passwordEncoder.encode("abcd")));
        userRepo.save(new UserApp("bob@example.com", passwordEncoder.encode("xyz")));

        System.out.println("Users insérés avec mot de passe encodé !");
    }
}