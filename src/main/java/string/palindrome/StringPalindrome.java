package string.palindrome;

public class StringPalindrome {

    public static void main(String[] args) {
        System.out.println(decimalDigit(12345, 0, 5));
        System.out.println(isPalindromeInt(12345));
        System.out.println(isPalindromeInt(99999));
    }

    public static boolean isPalindrome(String given) {
        return given.equals(new StringBuilder(given).reverse().toString());
    }

    public static boolean isPalindromeArray(String given) {
        int n = given.length();
        for (int i = 0; i < n / 2; i++) {
            if (given.charAt(i) != given.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeInt(int given) {
        int n = decimalDigitLength(given);
        for (int i = 0; i < n / 2; i++) {
            if (decimalDigit(given, i, n) != decimalDigit(given, n - 1 - i, n)) {
                return false;
            }
        }
        return true;
    }

    public static int decimalDigit(int given, int position, int n) {
        int delitelPower = n - position - 1;
        int deliter = (int) Math.pow(10, delitelPower);
        return (given / deliter) % 10;
    }

    public static int decimalDigitLength(int given) {
        int result = 1;
        int currentValue = given;
        while ((currentValue = currentValue / 10) != 0) {
            result += 1;
        }
        return result;
    }
}