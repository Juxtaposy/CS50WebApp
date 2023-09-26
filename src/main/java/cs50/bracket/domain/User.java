package cs50.bracket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;

    public User() {

    }

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public void setId(Long id){ this.id = id;}

    public void setLogin(String login){ this.login = login;}

    public void setPassword(String password) { this.password = password;}

    public String getLogin() { return login;}

    public boolean checkPassword(String confirmPassword) {
        return confirmPassword.equals(this.password);
    }

    public String getPassword() { return password; }
    public Long getId() { return id; }
}
