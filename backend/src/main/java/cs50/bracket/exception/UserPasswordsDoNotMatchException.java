package cs50.bracket.exception;

public class UserPasswordsDoNotMatchException extends RuntimeException{

    public UserPasswordsDoNotMatchException() {
        super("Passwords do not match");
    }
}
