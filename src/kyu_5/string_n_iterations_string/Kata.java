package kyu_5.string_n_iterations_string;

public class Kata {

    public static void main(String[] args) {

        // need optimize a code
        System.out.println(jumbledString("qwertyuio", 2));
    }

    public static String jumbledString(String s, long n) {
        StringBuilder leftPart = new StringBuilder();
        StringBuilder rightPart = new StringBuilder();

        while (n > 0) {
            for (int i = 0; i < s.length(); i += 2) {
                leftPart.append(s.charAt(i));
                if (i + 1 < s.length()) {
                    rightPart.append(s.charAt(i + 1));
                }
            }
            n--;
            s = leftPart.append(rightPart).toString();
            leftPart.setLength(0);
            rightPart.setLength(0);
        }

        return s;
    }
}
