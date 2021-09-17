package armstrong;

public class Armstrong {
    public static void main(String[] args) {
        System.out.println(isArmstrong(7));
    }
//1, 2, 3, 4, 5, 6, 7, 8, 9
    public static boolean isArmstrong(long n) {
        long power = 1;
        long i = n;

        while ((i = i / 10) != 0) {
            power++;
        }

        long buffer = 0;
        long current = n;

        while (current != 0) {
            buffer += Math.pow(current % 10, power);
            current = current / 10;
        }
        return buffer == n;
    }
}