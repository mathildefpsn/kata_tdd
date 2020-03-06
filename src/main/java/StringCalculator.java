import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    String add(String ...number) {
        List<List<String>> args = Arrays.stream(number)
                .filter(num -> !num.isEmpty())
                .map(num -> Arrays.asList(num.split(",")))
                .collect(Collectors.toList());
        if (args.size() == 0) return "0";
        return String.valueOf(args.stream()
                .flatMap(List::stream)
                .mapToDouble(Double::valueOf)
                .sum());
    }
}
