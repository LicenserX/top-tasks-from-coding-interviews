package removewhitespacefromstring;

public class RemoveWhiteSpaceFromString {
    public static void main(String[] args) {
        System.out.println(removeWhitespaces("1 2"));
        System.out.println(removeWhitespaces("1    2         "));
    }

    public static final String removeWhitespaces(String word) {
        String pattern = "\\s+";
        return word.replaceAll(pattern, "");
    }
}
