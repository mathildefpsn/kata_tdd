package exceptions;

public class NumberExpectedException extends ValueExpectedException {

    public NumberExpectedException(Integer position, String separator) {
        super("Number", position, separator);
    }
}
