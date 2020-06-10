package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class OnesZeros {

    public int findMaxForm(String[] strs, int m, int n) {

        int[][] counts = new int[strs.length][2];
        Map<String, Integer> dp = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            int[] count = new int[2];
            for (char c : strs[i].toCharArray()) {
                if (c == '0') count[0]++;
                if (c == '1') count[1]++;
            }
            counts[i] = count;
        }

        return maxStrings(counts, 0, m, n, dp);
    }


    private int maxStrings(int[][] counts, int i, int m, int n, Map<String, Integer> dp) {
        if (i > counts.length - 1) {
            return 0;
        }

        if (dp.containsKey(i + "_" + m + "_" + n)) return dp.get(i + "_" + m + "_" + n);
        int max = Integer.MIN_VALUE;
        int[] count = counts[i];
        if (count[0] <= m && count[1] <= n) {
            max = Math.max(max, 1 + maxStrings(counts, i + 1, m - count[0], n - count[1], dp));
        }
        max = Math.max(max, maxStrings(counts, i + 1, m, n, dp));
        dp.put(i + "_" + m + "_" + n, max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new OnesZeros().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
