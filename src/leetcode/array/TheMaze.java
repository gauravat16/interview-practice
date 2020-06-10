package leetcode.array;

public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return helper(maze, visited, destination, start[0], start[1]);
    }


    boolean helper(int[][] maze, boolean[][] visited, int[] destination, int r, int c) {
        if (r == destination[0] && c == destination[1]) {
            return true;
        }

        if (visited[r][c]) {
            return false;
        }

        visited[r][c] = true;

        int _r = r, _c = c;
        while (_c < maze[0].length && maze[_r][_c] == 0) {
            _c++;
        }

        if(helper(maze, visited, destination, _r, --_c)) return true;

        _r = r;
        _c = c;
        while (_c >= 0 && maze[_r][_c] == 0) {
            _c--;
        }

        if(helper(maze, visited, destination, _r, ++_c))  return true;

        _r = r;
        _c = c;
        while (_r >= 0 && maze[_r][_c] == 0) {
            _r--;
        }

        if(helper(maze, visited, destination, ++_r, _c))  return true;

        _r = r;
        _c = c;
        while (_r < maze.length && maze[_r][_c] == 0) {
            _r++;
        }

        if(helper(maze, visited, destination, --_r, _c)) return true;

        return false;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        System.out.println(new TheMaze().hasPath(maze, new int[]{0, 4}, new int[]{4, 4}));
    }
}
