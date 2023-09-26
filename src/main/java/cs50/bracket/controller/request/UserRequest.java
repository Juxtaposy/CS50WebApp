package cs50.bracket.controller.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UserRequest {

    private final String login;
    private final String password;

    @JsonCreator
    public UserRequest(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() { return login; }
    public boolean checkPassword(String inputPassword) {
        return inputPassword.equals(this.password);
    }

    public String getPassword() { return password; }
}
