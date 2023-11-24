package cs50.bracket.controller.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UserRegister {

    private final String login;
    private final String password;
    private final String confirmPassword;

    @JsonCreator
    public UserRegister(String login, String password, String confirmPassword){
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }



    public String getLogin() { return login; }
    public boolean checkPassword() {
        return password.equals(this.confirmPassword);
    }
    public String getPassword() { return password; }
    public String getConfirmPassword() { return confirmPassword; }
}
