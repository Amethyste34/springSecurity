package fr.diginamic.demo.controller;

import fr.diginamic.demo.service.CustomUserDetailsService;
import fr.diginamic.demo.entity.UserApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-app")
public class UserAppController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @GetMapping("/register")
    public String registerUser(@ModelAttribute UserApp userApp) throws Exception {
        customUserDetailsService.createUser(
                userApp.getEmail(),
                userApp.getPassword()
        );
        return "Utilisateur créé";
    }
}