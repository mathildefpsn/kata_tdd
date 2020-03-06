import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    private static final StringCalculator stringCalculator = new StringCalculator();

    @Test
    void should_return_sum_of_numbers() {
        String numbers = "1,2,3";

        assertEquals("6", stringCalculator.add(numbers));
    }

}
