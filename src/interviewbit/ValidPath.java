package interviewbit;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidPath {

    public String solve(int x, int y, int n, int r, List<Integer> cx, List<Integer> cy) {

        int[][] matrix = new int[x + 1][y + 1];
        for (int[] arr : matrix) {
            Arrays.fill(arr, 0);
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

        return bfs(matrix, dirs, 0, 0, x, y, r, cx, cy) ? "YES" : "NO";

    }

    private boolean bfs(int[][] matrix, int[][] dirs, int x, int y, int _x, int _y, int rad, List<Integer> cx, List<Integer> cy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if (matrix[point[0]][point[1]] == 1) {
                continue;
            }
            if (point[0] == _x && point[1] == _y) {
                return true;
            }
            matrix[point[0]][point[1]] = 1;
            for (int[] dir : dirs) {
                if (isValidPosition(matrix, dir[0] + point[0], dir[1] + point[1]) &&
                        !isInAnyCircle(dir[0] + point[0], dir[1] + point[1], rad, cx, cy)) {
                    queue.offer(new int[]{dir[0] + point[0], dir[1] + point[1]});
                }
            }

        }

        return false;
    }

    private boolean isValidPosition(int[][] matrix, int r, int c) {
        return r < matrix.length && r >= 0 && c >= 0 && c < matrix[r].length;
    }

    private boolean isInAnyCircle(int r, int c, int rad, List<Integer> cx, List<Integer> cy) {
        boolean isSafe = true;
        for (int i = 0; i < cx.size(); i++) {
            int _x = cx.get(i);
            int _y = cy.get(i);

            if(r == _x && c == _y){
                return true;
            }

            double dist = (int)Math.sqrt(Math.pow(_x - r, 2) + Math.pow(_y - c, 2));

            if(dist <= rad){
                isSafe = false;
                break;
            }

        }

        return !isSafe;
    }


    private boolean bfs(int[][] matrix, int[][] dirs, int x, int y, int r) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty() && r >= 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
//                if(matrix[point[0]][point[1]] == 1){
//                    continue;
//                }
                matrix[point[0]][point[1]] = 1;
                for (int[] dir : dirs) {
                    if (isValidPosition(matrix, dir[0] + point[0], dir[1] + point[1])) {
                        queue.offer(new int[]{dir[0] + point[0], dir[1] + point[1]});
                    }
                }
            }
            r--;
        }

        return false;
    }


    private void dfs(int[][] matrix, int[][] dirs, int x, int y, int r) {


        if (matrix[x][y] == 1) {
            return;
        }

        matrix[x][y] = 1;

        if (r == 0) {
            return;
        }


        for (int[] dir : dirs) {
            if (isValidPosition(matrix, dir[0] + x, dir[1] + y)) {
                dfs(matrix, dirs, dir[0] + x, dir[1] + y, r - 1);
            }
        }


    }

    private boolean dfs(int[][] matrix, int[][] dirs, int x, int y, int _x, int _y) {

        if (matrix[x][y] == 1) {
            return false;
        }

        matrix[x][y] = 1;


        if (x == _x && y == _y) {
            return true;
        }

        for (int[] dir : dirs) {
            if (isValidPosition(matrix, dir[0] + x, dir[1] + y)) {
                if (dfs(matrix, dirs, dir[0] + x, dir[1] + y, _x, _y)) {
                    return true;
                }

            }
        }

        return false;

    }


    public static void main(String[] args) {
//        System.out.println(new ValidPath().solve(37, 36, 8, 8, Arrays.asList(5, 36, 10, 6, 13, 37, 21, 35), Arrays.asList(17, 14, 20, 33, 26, 17, 4, 6)));
//        System.out.println(new ValidPath().solve(22, 47, 8, 9, Arrays.asList(6, 19, 17, 15, 13, 18, 20, 0), Arrays.asList(8, 15, 36, 8, 18, 15, 24, 47)));
//        System.out.println(new ValidPath().solve(78, 93, 2, 4, Arrays.asList(70, 24), Arrays.asList(63, 28)));
//        System.out.println(new ValidPath().solve(14, 3, 9, 0, Arrays.asList(3, 3, 0, 11, 8, 11, 14, 8, 4), Arrays.asList(1, 0, 2, 2, 0, 2, 3, 2, 1)));
//        System.out.println(new ValidPath().solve(61, 88, 2, 9, Arrays.asList(3, 55), Arrays.asList(18, 83)));

        System.out.println(new ValidPath().solve(41, 67, 5, 0, Arrays.asList(17, 16, 12, 0, 40), Arrays.asList(52, 61, 61, 25, 31)).equals("YES"));



    }
}
