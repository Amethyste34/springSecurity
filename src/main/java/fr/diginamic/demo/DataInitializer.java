package fr.diginamic.demo;

import fr.diginamic.demo.UserApp;
import fr.diginamic.demo.UserAppRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserAppRepository userRepo;

    public DataInitializer(UserAppRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Vérifie si des utilisateurs existent déjà pour ne pas les dupliquer
        if (userRepo.count() == 0) {
            userRepo.save(new UserApp("laurence@example.com", "1234"));
            userRepo.save(new UserApp("alice@example.com", "abcd"));
            userRepo.save(new UserApp("bob@example.com", "xyz"));
        }
    }
}