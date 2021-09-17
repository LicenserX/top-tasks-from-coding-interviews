package factorial;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(getFactorial(1));
        System.out.println(getFactorial(2));
        System.out.println(getFactorial(3));
        System.out.println(getFactorial(5));
        System.out.println(getFactorial(8));

    }

    private static final long getFactorial(long n) {
        long buffer = 1;
        long next = n;

        while (next != 1) {
            buffer *= next--;
        }
        return buffer;
    }
}
