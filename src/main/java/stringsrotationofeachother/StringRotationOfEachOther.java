package stringsrotationofeachother;

public class StringRotationOfEachOther {
    public static void main(String[] args) {
        System.out.println(isRotation("asd", "das"));
        System.out.println(isRotation("asd", "sda"));
        System.out.println(isRotation("asd", "sad"));
        System.out.println(isRotation("asd", "sds"));

    }

    public static final boolean isRotation(String source, String target) {
        char[] chars = source.toCharArray();
        int n =  chars.length;
        int j = n - 1;

        char[] rotatedChars;

        if (source.length() != target.length()) {
            return false;
        }

        if (source.equals(target)) {
            return true;
        }

        while (n != 0) {
            rotatedChars = new char[source.length()];
            rotatedChars[0] = chars[j];

            System.arraycopy(chars, 0, rotatedChars, 1, rotatedChars.length - 1);

            if (String.valueOf(rotatedChars).equals(target)) {
                return true;
            }
            chars = rotatedChars;
            n--;
        }
        return false;
    }
}
