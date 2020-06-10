package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class LongestArithemeticSeq {
    Map<String, Integer> memo = new HashMap<>();

    public int longestArithSeqLength(int[] A) {
        int maxLength = 0;

        for (int i = 0; i < A.length; i++) {

            maxLength = Math.max(maxLength, helper(A, i, null));
        }

        return maxLength;
    }


    private int helper(int[] arr, int idx, Integer diff) {
        if (idx >= arr.length) {
            return 0;
        }

        String key = idx+","+diff;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int val = arr[idx];
        int maxLength = 0;

        for (int i = idx + 1; i < arr.length; i++) {

            if (diff == null) {
                maxLength = Math.max(2 + helper(arr, i, val - arr[i]), maxLength);
            } else if (diff == (val - arr[i])) {
                maxLength = Math.max(maxLength, 1 + helper(arr, i, diff));
            }
        }

        memo.put(key, maxLength);

        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println(new LongestArithemeticSeq().longestArithSeqLength(new int[]{3,6,9,12}));
    }
}
