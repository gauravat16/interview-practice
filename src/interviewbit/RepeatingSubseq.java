package interviewbit;

public class RepeatingSubseq {

    public int anytwo(String A) {
        int[][] dp = new int[A.length()][A.length()];
        return helper(A, 0, 0, dp) >= 2 ? 1 : 0;
    }

    private int helper(String str, int i1, int i2, int[][] dp) {
        if (i1 >= str.length() || i2 >= str.length()) {
            return 0;
        }

        if (dp[i1][i2] > 0) {
            return dp[i1][i2];
        }
        if (str.charAt(i1) == str.charAt(i2) && i1 != i2) {
            return helper(str, i1 + 1, i2 + 1, dp) + 1;
        }


        return dp[i1][i2] = Math.max(helper(str, i1 + 1, i2, dp), helper(str, i1, i2 + 1, dp));
    }


    public static void main(String[] args) {
        System.out.println(new RepeatingSubseq().anytwo("aabb"));
    }
}
