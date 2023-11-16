package cs50.bracket.exception;

public class UserWrongLoginOrPasswordException extends RuntimeException{
    public UserWrongLoginOrPasswordException() {
        super("Incorrect Username or Password.");
    }
}
