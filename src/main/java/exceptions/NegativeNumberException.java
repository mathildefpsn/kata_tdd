package exceptions;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String numbers) {
        super("Negative not allowed : " + numbers);
    }
}
