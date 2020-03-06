import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeapYearsTest {

    private static final LeapYears leapYears = new LeapYears();

    @Test
    void should_return_true_if_divisible_by_400() {
        Integer a = 2000;
        assertEquals(true, leapYears.isLeapYear(a));
    }
}
