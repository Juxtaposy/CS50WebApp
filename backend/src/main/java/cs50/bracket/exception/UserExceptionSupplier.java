package cs50.bracket.exception;

import java.util.function.Supplier;

public class UserExceptionSupplier {

    public static Supplier<UserPasswordsDoNotMatchException> userPasswordDoesNotMatch() {
        return UserPasswordsDoNotMatchException::new;
    }

    public static Supplier<UserAlreadyExistsException> userAlreadyExistsException() {
        return UserAlreadyExistsException::new;
    }
}
