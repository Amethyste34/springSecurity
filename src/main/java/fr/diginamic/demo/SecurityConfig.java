package fr.diginamic.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/hello/public").permitAll()   // GET /hello/public
                        .requestMatchers("/hello/public").permitAll()   // POST /hello/public
                        .anyRequest().authenticated()                  // tout le reste doit être connecté
                )
                .formLogin(form -> form
                        .loginPage("/login")                           // page custom
                        .defaultSuccessUrl("/hello/private", true)     // redirection après login réussi
                        .usernameParameter("email")
                        .failureUrl("/hello/public")                   // redirection si login échoué
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/hello/public")             // redirection après logout
                        .permitAll()
                )
                .csrf(AbstractHttpConfigurer::disable);            // optionnel pour simplifier les tests POST

        return http.build();
    }
}