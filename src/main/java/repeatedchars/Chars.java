/*
 * Copyright 2021 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */
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
