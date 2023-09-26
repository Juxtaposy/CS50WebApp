package cs50.bracket.exception;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException()
    {
        super("User already exists");
    }
}
