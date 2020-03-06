public class FizzBuzz {

    public String getPrintValue(Integer number) {
        String fizz = number % 3 == 0 ? "fizz" : "";
        String buzz = number % 5 == 0 ? "buzz" : "";
        String output = fizz.concat(buzz);
        return !output.equals("") ? output : number.toString();
    }
}
