package leetcode.graph;

public class WordSearch {

    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (helper(board, r, c, word, 0, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean helper(char[][] board, int r,
                           int c, String word, int idx, boolean[][] visited) {
        if (idx >= word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length || visited[r][c]) return false;

        char currChar = word.charAt(idx);
        if (currChar != board[r][c]) return false;

        boolean hasWord = false;

        for (int[] dir : dirs) {
            visited[r][c] = true;
            hasWord |= helper(board, r + dir[0], c + dir[1], word, idx + 1, visited);

            visited[r][c] = false;
        }

        return hasWord;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][]{{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}
