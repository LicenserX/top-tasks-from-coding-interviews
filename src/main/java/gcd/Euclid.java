package gcd;

public class Euclid {
    public static void main(String[] args) {
        System.out.println(euclidRecursive(1, 1));
        System.out.println(euclidRecursive(40, 2));
        System.out.println(euclidRecursive(2, 40));
        System.out.println(euclidRecursive(7, 14));
        System.out.println(euclidPlain(1, 1));
        System.out.println(euclidPlain(40, 2));
        System.out.println(euclidPlain(2, 40));
        System.out.println(euclidPlain(7, 14));
    }

    public static int euclidRecursive(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (max % min == 0) {
            return min;
        } else {
            return euclidRecursive(max, min);
        }
    }

    public static int euclidPlain(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int buffer;
        while (max % min != 0) {
            buffer = max % min;
            max = min;
            min = buffer;
        }
        return min;
    }
}
