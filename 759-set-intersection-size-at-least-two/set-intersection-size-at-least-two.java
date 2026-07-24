import java.util.Arrays;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1])
                return b[0] - a[0];
            return a[1] - b[1];
        });

        int first = -1;
        int second = -1;
        int ans = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start > second) {
                // Need two new numbers
                ans += 2;
                first = end - 1;
                second = end;
            } else if (start > first) {
                // Need one more number
                ans += 1;
                first = second;
                second = end;
            }
        }

        return ans;
    }
}