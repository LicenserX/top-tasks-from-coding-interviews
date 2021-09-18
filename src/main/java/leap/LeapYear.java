package leap;

public class LeapYear {
    public static void main(String[] args) {
        System.out.println(isLeapYear(2020));
        System.out.println(isLeapYear(400));
        System.out.println(isLeapYear(2021));
        System.out.println(isLeapYear(2000));
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else return year % 4 == 0;
    }
}
