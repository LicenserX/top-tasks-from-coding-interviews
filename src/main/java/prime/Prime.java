package prime;

import java.util.function.Consumer;

public class Prime {

    public static void main(String[] args) {
        eratosphen(10000, integer -> {
            System.out.println(isPrime(integer));
        });
    }

    public static boolean dumbIsPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void eratosphen(int n, Consumer<Integer> callback) {
        final int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = i;
        }
        for (int i = 2; i < n; i++) {
            if (values[i] != -1) {
                callback.accept(values[i]);
                for (int j = i; j < n; j += i) {
                    values[j] = -1;
                }
            }
        }
    }
}