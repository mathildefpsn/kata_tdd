package exceptions;

public class DelimiterExpectedException extends ValueExpectedException {
    public DelimiterExpectedException(String delimiterExpected, Integer position, String delimiterFound) {
        super("'" + delimiterExpected + "'", position, delimiterFound);
    }

}
