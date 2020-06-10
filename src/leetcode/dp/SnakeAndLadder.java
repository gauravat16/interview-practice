package leetcode.dp;

import java.util.*;

public class SnakeAndLadder {

    public int snakesAndLadders(int[][] board) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int num = q.poll();
            if (num == board.length * board.length) {
                return map.get(num);
            }

            for (int i = num + 1; i <= Math.min(num + 6, board.length * board.length); i++) {
                int[] pos = getPos(board.length, i);
                int r = pos[0], c = pos[1];

                int newNum = board[r][c] != -1 ? board[r][c] : i;
                if (!map.containsKey(newNum)) {
                    map.put(newNum, map.get(num) + 1);
                    q.offer(newNum);
                }
            }

        }
        return -1;
    }


    int[] getPos(int N, int num) {
        int q = (num - 1) / N;
        int rem = (num - 1) % N;

        int r = N - 1 - q;
        int c = r % 2 != N % 2 ? rem : N - 1 - rem;
        return new int[]{r, c};
    }
}
