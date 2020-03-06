import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    String add(String number) {
        if (number.isEmpty()) return "0";
        List<String> numbers = Arrays.asList(number.split(","));
        return String.valueOf(numbers.stream()
                .mapToDouble(Double::valueOf)
                .sum());
    }
}
