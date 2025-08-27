package fr.diginamic.demo;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/public")
    public String HelloPublic() {
        return "Hello public";
    }

    @GetMapping("/private")
    public String helloPrivate() {
        return "Hello private";
    }

    @PostMapping("/public")
    public String helloPublicPost() {
        return "Hello public (POST)";
    }

    @GetMapping("/me")
    public String currentUser(org.springframework.security.core.Authentication authentication) {
        if (authentication == null) {
            return "Aucun utilisateur connecté.";
        }
        return "Utilisateur connecté : " + authentication.getName();
    }

}