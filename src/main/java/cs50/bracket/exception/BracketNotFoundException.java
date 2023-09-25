package cs50.bracket.exception;

public class BracketNotFoundException extends RuntimeException{

    public BracketNotFoundException(Long id){
        super(String.format("Bracket with ID %d not found", id));
    }
}
