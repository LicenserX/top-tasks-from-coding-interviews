import java.util.Arrays;

public class CountSort {
    private static final int OFFSET = 97;

    public static void main(String[] args) {
        System.out.println(charSort(new char[]{'b', 'c', 'd', 'a', 'b', 'c', 'd', 'a', 'b', 'c', 'd', 'a'}));
    }

    public static char[] charSort(char[] given) {
        int[] ints = new int[26];
        for (char c : given) {
            ints[c - OFFSET] += 1;
        }
        char[] result = new char[given.length];
        int curPos = 0;
        for (int i = 0; i < ints.length; i++) {
            int curCount = ints[i];
            for (int j = 0; j < curCount; j++) {
                result[curPos] = (char)(i + OFFSET);
                curPos++;
            }
        }
        return result;
    }
}
