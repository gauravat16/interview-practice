package leetcode.dp;

import java.util.Arrays;
import java.util.Map;

public class MatrixBlockSum {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int n = mat.length, m = mat[0].length;

        int[][] sum = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int r1 = Math.max(0, i - K) + 1;
                int r2 = Math.min(n - 1, i + K) + 1;
                int c1 = Math.max(0, j - K) + 1;
                int c2 = Math.min(m - 1, j + K) + 1;

                ans[i][j] = sum[r2][c2] - sum[r2][c1 - 1] - sum[r1 - 1][c2] + sum[r1 - 1][c1 - 1];


            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(new MatrixBlockSum().matrixBlockSum(mat, 1)));
    }
}
