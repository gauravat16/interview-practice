package leetcode.dp;

public class FillingBookshelves {

    public int minHeightShelves(int[][] books, int shelf_width) {
        int[][] dp = new int[books.length][shelf_width + 1];
        return helper(books, shelf_width, shelf_width, 0, 0, dp);
    }


    private int helper(int[][] books, int shelf_width, int width, int idx, int height, int[][] dp) {
        if (idx == books.length) {
            return height;
        }

        if(dp[idx][width] > 0){
            return dp[idx][width];
        }
        int placedHere = Integer.MAX_VALUE;

        if (books[idx][0] <= width) {
            placedHere = helper(books, shelf_width, width - books[idx][0], idx + 1, Math.max(height, books[idx][1]), dp);
        }

        int placedNext = height + helper(books, shelf_width, shelf_width - books[idx][0], idx + 1, books[idx][1], dp);

        return dp[idx][width] = Math.min(placedHere, placedNext);

    }

    public static void main(String[] args) {

        int[][] books = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        System.out.println(new FillingBookshelves().minHeightShelves(books, 4));
    }
}
