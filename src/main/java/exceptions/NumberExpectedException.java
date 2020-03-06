package exceptions;

public class NumberExpectedException extends RuntimeException {
    public NumberExpectedException(Integer position, String separator) {
        super("Number expected but '" + separator + "' found at position " + position + ".");
    }
}
