package cs50.bracket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    @Enumerated
    private Role role;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() { return password; }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() { return id; }
}
