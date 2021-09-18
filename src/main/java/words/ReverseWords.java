package words;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("Adam kicked the bucket"));
        System.out.println(reverseWords("Johnny hit the road"));
    }

    public static String reverseWords(String given) {
        String[] split = given.split("\\s+");
        System.out.println("Split length=" + split.length);
        List<String> splitList = Arrays.asList(split);
        Collections.reverse(splitList);
        return String.join(" ", splitList);
    }
}
