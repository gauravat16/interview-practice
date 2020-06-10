package leetcode.array;

public class MaxSumLMArray {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {

        int[] runningSum = new int[A.length];
        runningSum[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            runningSum[i] += A[i] + runningSum[i - 1];
        }

        return Math.max(getSum(runningSum, L, M), getSum(runningSum, M, L));

    }


    int getSum(int[] runningSum, int L, int M) {
        int maxSum = 0, maxL = 0;

        for (int i = L + M -1 ; i < runningSum.length; i++) {
            maxL = Math.max(maxL, runningSum[i - M] - ((i - L - M < 0)? 0 : runningSum[i - L - M ]));
            maxSum = Math.max(maxSum, maxL + runningSum[i] - runningSum[i - M]);
        }

        return maxSum;

    }

    public static void main(String[] args) {
        System.out.println(new MaxSumLMArray().maxSumTwoNoOverlap(new int[]{1,0,1}, 1, 1));
    }

}
