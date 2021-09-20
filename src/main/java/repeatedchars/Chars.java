package repeatedchars;

public class Chars {
    public static void main(String[] args) {
            printRepeatedChars("Many hands make light work");
    }

    public static void printRepeatedChars(String word) {
        boolean[] isAlreadyPrinted = new boolean[word.length()];

        for (int i = 0; i < word.length() - 1; i++) {
            if (isAlreadyPrinted[i]) {
                continue;
            }
            int counter = 1;
            for (int j = i + 1; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    isAlreadyPrinted[j] = true;
                    counter++;
                }
            }
            if (counter > 1) {
                while (counter > 0) {
                    System.out.print(word.charAt(i));
                    counter--;
                }
            }
        }
    }
}
