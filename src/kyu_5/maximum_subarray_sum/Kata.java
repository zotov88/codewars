package kyu_5.maximum_subarray_sum;

public class Kata {

    public static void main(String[] args) {
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sequence(array));
    }

    public static int sequence(int[] array) {
        int maxSecquence = 0;
        int currentSum = 0;

        for (int i : array) {
            currentSum = Math.max(0, currentSum + i);
            maxSecquence = Math.max(maxSecquence, currentSum);
        }

        return maxSecquence;
    }
}
