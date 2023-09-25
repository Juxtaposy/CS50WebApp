package cs50.bracket.exception;

import java.util.function.Supplier;

public class BracketExceptionSupplier {

    public static Supplier<BracketNotFoundException> bracketNotFound(Long id){
        return () -> new BracketNotFoundException(id);
    }
}
