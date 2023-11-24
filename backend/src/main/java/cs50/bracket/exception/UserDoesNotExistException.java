package cs50.bracket.exception;

public class UserDoesNotExistException extends RuntimeException{
    public UserDoesNotExistException() {
        super("User with given name does not exist.");
    }
}
