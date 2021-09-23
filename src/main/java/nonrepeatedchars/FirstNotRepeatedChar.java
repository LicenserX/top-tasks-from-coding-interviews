/*
 * Copyright 2021 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */
package nonrepeatedchars;

public class FirstNotRepeatedChar {
    public static void main(String[] args) {
        System.out.println(getFirstNonRepeatedChar("aassdd"));
        System.out.println(getFirstNonRepeatedChar("aaasssddd"));
        System.out.println(getFirstNonRepeatedChar("asssddd"));
        System.out.println(getFirstNonRepeatedChar("asssdddasdg"));
        System.out.println(getFirstNonRepeatedChar("asssdddaqwersdrgsdqfqerw"));

    }

    public static char getFirstNonRepeatedChar(String word) {
        int length = word.length();
        boolean[] isAlreadyChecked = new boolean[length];

        for (int i = 0; i < length - 1; i++) {
            if (isAlreadyChecked[i]) {
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    isAlreadyChecked[i] = true;
                    isAlreadyChecked[j] = true;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (!isAlreadyChecked[i]) {
                return word.charAt(i);
            }
        }
        return ' ';
    }
}
