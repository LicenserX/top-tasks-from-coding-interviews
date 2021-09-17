package fibo;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(recursiveFibonacci(8) == memoizationFibonacci(8));
        System.out.println(recursiveFibonacci(8) == twoVarsFibonacci(8));
        System.out.println(memoizationFibonacci(8) == twoVarsFibonacci(8));
        System.out.println(threeVarsFibonacci(8) == twoVarsFibonacci(8));
    }

    public static int recursiveFibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static int memoizationFibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] values = new int[n];
        values[0] = 1;
        values[1] = 1;
        for (int i = 2; i < n; i++) {
            values[i] = values[i - 1] + values[i - 2];
        }
        return values[n - 2] + values[n - 1];
    }

    public static int twoVarsFibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int first = 1;
        int second = 1;

        for (int i = 2; i < n; i++) {
            second = first + second;
            first = second - first;
        }

        return first + second;
    }

    public static int threeVarsFibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int buffer = 0;

        for (int i = 2; i < n; i++) {
            buffer = first + second;
            first = second;
            second = buffer;
        }

        return first + second;
    }
}
