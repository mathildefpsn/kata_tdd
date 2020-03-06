public class LeapYears {

    public Boolean isLeapYear(Integer year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }
}
