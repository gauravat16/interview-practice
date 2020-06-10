package leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BuSellStock2 {

    public int maxProfit(int[] prices) {
        Map<String, Integer> dp = new HashMap<>();

        int val = helper(prices, 0, false, dp);
        System.out.println(dp);
        return val;

    }

    private int helper(int[] prices, int i, boolean hasStock, Map<String, Integer> dp) {
        if (i > prices.length - 1) {
            return 0;
        }

        if (dp.containsKey(i + "_" + hasStock)) {
            System.out.println("i" + i + " ==> " + dp.get(i + "_" + hasStock));
            return dp.get(i + "_" + hasStock);
        }

        int buy = 0, sell = 0, leave = 0;

        if (!hasStock) {
            buy = helper(prices, i + 1, true, dp) - prices[i];
        }

        if (hasStock) {
            sell = helper(prices, i + 1, false, dp) + prices[i];
        }

        leave = helper(prices, i + 1, hasStock, dp);

        dp.put(i + "_" + hasStock, Math.max(buy, Math.max(sell, leave)));

        return dp.get(i + "_" + hasStock);

    }

    public static void main(String[] args) {
        System.out.println(new BuSellStock2().maxProfit(new int[]{1, 2, 3, 4, 5}));
    }
}

