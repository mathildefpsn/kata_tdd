import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    private final static FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    void should_return_number_if_not_divisible_by_3_or_5_or_both() {
        Integer a = 11;
        assertEquals("11", fizzBuzz.getPrintValue(a));
    }

    @Test
    void should_return_fizz_if_divisible_by_3() {
        Integer a = 9;
        assertEquals("fizz", fizzBuzz.getPrintValue(a));
    }

    @Test
    void should_return_buzz_if_divisible_by_5() {
        Integer a = 25;
        assertEquals("buzz", fizzBuzz.getPrintValue(a));
    }
}
