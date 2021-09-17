package pattern;

public class Pattern {
    public static void main(String[] args) {
        printPattern(10);
        printPyramidPattern(10);
    }

    public static void printPattern(int deep) {
        String pattern = "*";
        String whitespace = " ";
        String result = pattern;
        if (deep == 0) {
            return;
        }

        while (deep > 0) {
            System.out.println(result);
            result = result + whitespace + pattern;
            deep--;
        }
    }

    public static void printPyramidPattern(int deep) {
        String pattern = "*";
        String whitespace = " ";
        String result = whitespace;
        String nextPattern = pattern;

        while (deep != 0) {
            for (int i = 0; i < deep - 1; i++) {
                result += whitespace;
            }
            result += nextPattern;
            System.out.println(result);
            nextPattern = nextPattern + whitespace + pattern;
            result = whitespace;
            deep--;
        }
    }


}
