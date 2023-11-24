package cs50.bracket.controller.response;

public class UserResponse {

    private final Long id;
    private final String login;

    public UserResponse(Long id, String login){
        this.id = id;
        this.login = login;
    }

    public Long getId() { return id; }

    public String getLogin() { return login; }
}
