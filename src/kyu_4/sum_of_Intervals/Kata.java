package kyu_4.sum_of_Intervals;

public class Kata {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 20},
                {-100000000, 10},
                {30, 40}
        };
        System.out.println(sumIntervals(arr));
    }

    public static int sumIntervals(int[][] intervals) {
        int result = 0;
        for (int i = 0; i < intervals.length; i++) {
            boolean isNotIntersection = true;
            for (int j = i + 1; j < intervals.length; j++) {
                if (isIntersection(intervals, i, j)) {
                    isNotIntersection = false;
                    break;
                }
            }
            if (isNotIntersection) {
                result += calculateInterval(intervals, i);
            }
        }
        return result;
    }

    private static boolean isIntersection(int[][] intervals, int i, int j) {
        boolean result = false;
        int tl = intervals[i][0];
        int tr = intervals[i][1];
        int dl = intervals[j][0];
        int dr = intervals[j][1];
        if (tl >= dl && tl <= dr || dl >= tl && dl <= tr) {
            intervals[j][0] = getMin(tl, tr, dl, dr);
            intervals[j][1] = getMax(tl, tr, dl, dr);
            intervals[i][0] = intervals[i][1] = 0;
            result = true;
        }
        return result;
    }

    private static int getMax(int tl, int tr, int dl, int dr) {
        return Math.max(Math.max(tl, Math.max(tr, dl)), dr);
    }

    private static int getMin(int tl, int tr, int dl, int dr) {
        return Math.min(Math.min(tl, Math.min(tr, dl)), dr);
    }

    private static int calculateInterval(int[][] intervals, int i) {
        return intervals[i][1] - intervals[i][0];
    }
}
