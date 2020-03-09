package exceptions;

public abstract class ValueExpectedException extends RuntimeException {
    public ValueExpectedException(String valueExpected ,Integer position, String separator) {
        super(valueExpected + " expected but '" + separator + "' found at position " + position + ".");
    }
}
