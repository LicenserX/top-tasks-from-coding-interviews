package permutationsofstring;

public class PermutationsOfString {
    public static void main(String[] args) {
//        printAllPermutations("GOD");
        System.out.println("");
        printAllPermutations("YODA");
        System.out.println("");
        permutation("YODA");
    }

    public static final void printAllPermutations(String word) {
        StringBuilder builder = new StringBuilder(word);

        int n = word.length();

        while (n != 0) {
            int i = 0;
            while (i < word.length() - 1) {
                swap(builder, i++, i);
                System.out.println(builder);
            }
            n--;
        }
    }

    public static void permutation(String input){
        permutation("", input);
    }



    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.err.println(perm + word);

        } else {
            for (int i = 0; i < word.length(); i++) {
                String substring = word.substring(0, i);
                String substring1 = word.substring(i + 1, word.length());
                permutation(perm + word.charAt(i), substring + substring1);
            }
        }
    }




    public static final void swap(StringBuilder builder, int i, int j) {
        char v = builder.charAt(i);
        builder.setCharAt(i, builder.charAt(j));
        builder.setCharAt(j, v);
    }
}
