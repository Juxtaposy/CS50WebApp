package cs50.bracket.controller.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UserLogin {

    private final String login;
    private final String password;

    @JsonCreator
    public UserLogin(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() { return login; }
    public String getPassword() {return password; }
}
