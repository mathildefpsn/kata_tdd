import exceptions.MissingNumberException;
import exceptions.NumberExpectedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final String BAD_SEPARATOR_1 = ",\n";
    private static final String BAD_SEPARATOR_2 = "\n,";
    private static final String BAD_SEPARATOR_1_TO_PRINT = ",\\n";
    private static final String BAD_SEPARATOR_2_TO_PRINT = "\\n,";
    private static final String INITIAL_SEPARATORS = "[(,)|(\\n)]";
    private static final String CHANGING_SEPARATOR = "//";

    private String SEPARATORS = "[(,)|(\\n)]";

    String add(String ...number) {
        this.init();
        List<List<String>> numbersLists = Arrays.stream(number)
                .filter(num -> !num.isEmpty())
                .map(num -> {
                    try {
                        num = this.checkSeparator(num);
                        return Arrays.asList(num.split(SEPARATORS));
                    } catch (NumberExpectedException | MissingNumberException e) {
                        throw e;
                    }
                })
                .collect(Collectors.toList());
        if (numbersLists.size() == 0) return "0";
        return String.valueOf(numbersLists.stream()
                .flatMap(List::stream)
                .filter(num -> !num.isEmpty())
                .mapToDouble(Double::valueOf)
                .sum());
    }

    private void init() {
        if (!SEPARATORS.equals(INITIAL_SEPARATORS)) SEPARATORS = INITIAL_SEPARATORS;
    }

    private String checkSeparator(String numbers) {
        if (numbers.startsWith(CHANGING_SEPARATOR)) {
            int changingSeparatorLength = CHANGING_SEPARATOR.length();
            SEPARATORS = numbers.substring(changingSeparatorLength, changingSeparatorLength + 1);
            return numbers.substring(3 + SEPARATORS.length());
        } else if (numbers.contains(BAD_SEPARATOR_1)) {
            throw new NumberExpectedException(numbers.indexOf(BAD_SEPARATOR_1), BAD_SEPARATOR_1_TO_PRINT);
        } else if (numbers.contains(BAD_SEPARATOR_2)) {
            throw new NumberExpectedException(numbers.indexOf(BAD_SEPARATOR_2), BAD_SEPARATOR_2_TO_PRINT);
        } else if (String.valueOf(numbers.charAt(numbers.length() - 1)).matches(SEPARATORS)) {
            throw new MissingNumberException();
        }
        return numbers;
    }
}
