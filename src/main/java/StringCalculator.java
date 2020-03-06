import java.util.ArrayList;

public class StringCalculator {

    String add(String number) {
        String[] numbers = number.split(",");
        double sum = 0;
        for (String num: numbers) {
            sum += Double.parseDouble(num);
        }
        return String.valueOf(sum);
    }
}
