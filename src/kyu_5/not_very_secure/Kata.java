package kyu_5.not_very_secure;

public class Kata {

    public static void main(String[] args) {
        System.out.println(alphanumeric("nave"));
    }

    public static boolean alphanumeric(String s) {
        if (s.isEmpty()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!characterIsAllowed(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean characterIsAllowed(char ch) {
        return (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}
