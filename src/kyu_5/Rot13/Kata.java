package kyu_5.Rot13;

public class Kata {

    private final static String STR = "Aa4X-+z";
    private final static int OFFSET = 13;
    private final static int MIN_UPPER = 65;
    private final static int MAX_UPPER = 90;
    private final static int MIN_LOWER = 97;
    private final static int MAX_LOWER = 122;


    public static void main(String[] args) {
        System.out.println(rot13(STR));
    }

    public static String rot13(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= MIN_LOWER && c <= MAX_LOWER) {
                sb.append(handleLowerCase(c));
            } else if (c >= MIN_UPPER && c <= MAX_UPPER) {
                sb.append(handleUpperCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static char handleLowerCase(char c) {
        int newPosition = c + OFFSET;
        if (newPosition > MAX_LOWER) {
            newPosition = MIN_LOWER - 1 + newPosition % MAX_LOWER;
        }

        return (char) newPosition;
    }

    private static char handleUpperCase(char c) {
        int newPosition = c + OFFSET;
        if (newPosition > MAX_UPPER) {
            newPosition = MIN_UPPER - 1 + newPosition % MAX_UPPER;
        }

        return (char) newPosition;
    }


}