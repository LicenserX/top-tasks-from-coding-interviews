package reversestringinplace;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseStringInPlace("word"));
    }

    public static final String reverseStringInPlace(String word) {
       StringBuilder builder = new StringBuilder(word);

        int n = builder.length() / 2;

        for (int i = 0; i < n; i++) {
            int j = builder.length() -1 - i;

            char buffer = builder.charAt(i);
            char ch = builder.charAt(j);
            builder.setCharAt(i, ch);
            builder.setCharAt(j, buffer);
        }

        return builder.toString();
    }
}
