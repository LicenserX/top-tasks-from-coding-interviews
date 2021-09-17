package reversestring;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("abcdef"));
        System.out.println(reverseString("ABBA"));
        System.out.println(reverseString("tenet"));
        System.out.println(reverseString("Dimon"));
    }

    private static final String reverseString(String word) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = word.length() - 1 ; i >= 0;  i--) {
            reversedString.append(word.charAt(i));
        }
        return reversedString.toString();
    }
}
