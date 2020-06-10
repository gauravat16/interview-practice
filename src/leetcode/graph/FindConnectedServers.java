package leetcode.graph;

public class FindConnectedServers {

    public int countServers(int[][] grid) {

        int[] rowCount = new int[grid.length];
        int[] colCount = new int[grid[0].length];

        int total = 0, notConnected = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    rowCount[r]++;
                    colCount[c]++;
                    total++;
                }
            }
        }


        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (rowCount[r] == 0 && colCount[c] == 0) {
                    notConnected++;
                }
            }
        }


        return total - notConnected;

    }


    public int countServers1(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (!visited[r][c] && grid[r][c] == 1) {
                    int val = helper(grid, visited, r, c);
                    count += val == 1 ? 0 : val;
                }
            }
        }

        return count;

    }

    private int helper(int[][] grid, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        int length = 1;

        for (int _r = 0; _r < grid.length; _r++) {
            if (!visited[_r][c] && grid[_r][c] == 1) {
                length += helper(grid, visited, _r, c);
            }
        }

        for (int _c = 0; _c < grid[r].length; _c++) {
            if (!visited[r][_c] && grid[r][_c] == 1) {
                length += helper(grid, visited, r, _c);
            }
        }


        return length;

    }

    public static void main(String[] args) {
        System.out.println(new FindConnectedServers().countServers(new int[][]{{0, 0, 1, 0, 1}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}, {1, 0, 0, 1, 1}, {0, 0, 1, 1, 0}}));
    }
}
