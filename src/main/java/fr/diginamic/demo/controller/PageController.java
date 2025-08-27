package fr.diginamic.demo.controller;

import fr.diginamic.demo.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @Autowired
    private CustomUserDetailsService service;

    @GetMapping("/register")
    public String createUserPage() {
        return "register";
    }

    @PostMapping("/register")
    public String createUser(@RequestParam String email, @RequestParam String password) {
        service.createUser(email, password); // ajouter en BDD
        return "redirect:/register?success";  // redirection après insertion
    }

    @GetMapping("/add-article")
    public String addArticle() {
        return "add-article";
    }
}