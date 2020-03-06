import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    String add(String ...number) {
        if (number.length == 0) return "0";
        List<List<String>> args = Arrays.stream(number)
                .filter(num -> !num.isEmpty())
                .map(num -> Arrays.asList(num.split(",")))
                .collect(Collectors.toList());
        if (args.size() == 0) return "0";
        List<String> numbers =
                args.stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList());

        return String.valueOf(numbers.stream()
                .mapToDouble(Double::valueOf)
                .sum());
    }
}
