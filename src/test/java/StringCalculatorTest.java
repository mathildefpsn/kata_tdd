import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
