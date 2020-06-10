package leetcode.dp;

import java.util.Arrays;

public class CountSquares {
    public int countSquares(int[][] matrix) {

        int[][] sqMat = new int[matrix.length][matrix[0].length];

        int count = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 1) {
                    int v1 = isPosValid(r - 1, c, sqMat) ? sqMat[r - 1][c] : 0;
                    int v2 = isPosValid(r, c - 1, sqMat) ? sqMat[r][c - 1] : 0;
                    int v3 = isPosValid(r - 1, c - 1, sqMat) ? sqMat[r - 1][c - 1] : 0;
                    int min = Math.min(v1, Math.min(v2, v3));

                    if (v1 == 0 || v2 == 0 || v3 == 0) {
                        sqMat[r][c] = 1;
                        count++;
                    } else {
                        sqMat[r][c] = min + 1;
                        count += min + 1;
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(sqMat));
        return count;

    }

    private boolean isPosValid(int r, int c, int[][] mat) {
        return r >= 0 && r < mat.length && c >= 0 && c < mat[r].length;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(new CountSquares().countSquares(mat));
    }
}
