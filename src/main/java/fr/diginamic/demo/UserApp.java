package fr.diginamic.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "user_app") // nom de la table personnalisé
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String email;

    private String password;

    public UserApp() {}

    public UserApp(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters / Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}