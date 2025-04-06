import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[] arr1 = new char[]{'a', 'b', 'c'};
        char[] arr3 = new char[arr1.length];
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr3));
        System.out.println();

        arr1[0] = 'z';
        arr3[2] = 'x';

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr3));
    }
}
