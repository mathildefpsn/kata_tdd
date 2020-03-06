package exceptions;

public class MissingNumberException extends RuntimeException {
    public MissingNumberException() {
        super("Number expected but EOF found");
    }
}
