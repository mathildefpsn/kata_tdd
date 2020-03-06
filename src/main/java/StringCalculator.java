import exceptions.MissingNumberException;
import exceptions.NumberExpectedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    String add(String ...number) {
        List<List<String>> args = Arrays.stream(number)
                .filter(num -> !num.isEmpty())
                .map(num -> {
                    try {
                        String badSeparator1 = ",\n";
                        String badSeparator2 = "\n,";
                        if (num.contains(badSeparator1)) {
                            throw new NumberExpectedException(num.indexOf(badSeparator1),",\\n");
                        } else if (num.contains(badSeparator2)) {
                            throw new NumberExpectedException(num.indexOf(badSeparator2),"\\n,");
                        }
                        String[] numbersArray = num.split("[(,)|(\\n)]");
                        if (numbersArray[numbersArray.length - 1].isEmpty()) throw new MissingNumberException();
                        return Arrays.asList(numbersArray);
                    } catch (NumberExpectedException e) {
                        throw e;
                    }
                })
                .collect(Collectors.toList());
        if (args.size() == 0) return "0";
        return String.valueOf(args.stream()
                .flatMap(List::stream)
                .filter(num -> !num.isEmpty())
                .mapToDouble(Double::valueOf)
                .sum());
    }
}
