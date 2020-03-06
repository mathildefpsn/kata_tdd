import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeapYearsTest {

    private static final LeapYears leapYears = new LeapYears();

    @Test
    void should_return_true_if_divisible_by_400() {
        Integer a = 2000;
        assertEquals(true, leapYears.isLeapYear(a));
    }

    @Test
    void should_return_false_if_divisible_by_100_and_not_by_400() {
        Integer a = 1700;
        assertEquals(false, leapYears.isLeapYear(a));
    }

    @Test
    void should_return_true_if_divisible_by_4_and_not_by_100() {
        Integer a = 2008;
        assertEquals(true, leapYears.isLeapYear(a));
    }
}
