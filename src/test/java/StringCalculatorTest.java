import exceptions.DelimiterExpectedException;
import exceptions.MissingNumberException;
import exceptions.NegativeNumberException;
import exceptions.NumberExpectedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorTest {

    private static final StringCalculator stringCalculator = new StringCalculator();

    @Test
    void should_return_sum_of_numbers() {
        String numbers = "1.2,2,3";

        assertEquals("6.2", stringCalculator.add(numbers));
    }

    @Test
    void should_return_0_if_input_is_empty_string() {
        String numbers = "";

        assertEquals("0", stringCalculator.add(numbers));
    }

    @Test
    void should_return_sum_of_numbers_with_an_unknown_number_of_arguments() {
        String[] numbers = new String[]{"", "1.2,2,3", "2"};

        assertEquals("8.2", stringCalculator.add(numbers));
    }

    @Test
    void should_return_sum_of_numbers_with_new_line_separator() {
        String numbers = "1.2\n2,3";

        assertEquals("6.2", stringCalculator.add(numbers));
    }

    @Test
    void should_return_exception_with_separators_joined() {
        Exception exception = assertThrows(NumberExpectedException.class, () -> {
            String numbers = "1.2\n2,\n3";
            stringCalculator.add(numbers);
        });

        String expectedMessage = "Number expected but ',\\n' found at position 5.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void should_return_exception_if_last_position_empty() {
        Exception exception = assertThrows(MissingNumberException.class, () -> {
            String numbers = "12,3,";
            stringCalculator.add(numbers);
        });

        String expectedMessage = "Number expected but EOF found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void should_return_sum_if_change_delimiter() {
        String numbers = "//;\n1;2";

        assertEquals("3.0", stringCalculator.add(numbers));
    }

    @Test
    void should_return_exception_if_bad_delimiter_after_changing() {
        Exception exception = assertThrows(DelimiterExpectedException.class, () -> {
            String numbers = "//|\n1|2,3";
            stringCalculator.add(numbers);
        });

        String expectedMessage = "'|' expected but ',' found at position 3.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void should_return_exception_if_negative_number() {
        Exception exception = assertThrows(NegativeNumberException.class, () -> {
            String numbers = "-1,2";
            stringCalculator.add(numbers);
        });

        String expectedMessage = "Negative not allowed : -1";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
