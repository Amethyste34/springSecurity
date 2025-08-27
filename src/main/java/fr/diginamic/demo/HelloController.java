package fr.diginamic.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello-public")
    public String HelloPublic() {
        return "Hello public";
    }

    @GetMapping("/hello-private")
    public String helloPrivate() {
        return "Hello private";
    }
}