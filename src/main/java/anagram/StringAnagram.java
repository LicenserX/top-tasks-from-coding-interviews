package anagram;

import java.util.HashMap;
import java.util.Map;

public class StringAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("Æʥɯ", "ʥÆɯ"));
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        return gistify(str1).equals(gistify(str2));
    }

    private static Map<Character, Integer> gistify(String str1) {
        Map<Character, Integer> gist = new HashMap<>();
         for (char cur: str1.toCharArray()) {
            gist.putIfAbsent(cur, 0);
            gist.put(cur, gist.get(cur) + 1);
        }
        return gist;
    }
}