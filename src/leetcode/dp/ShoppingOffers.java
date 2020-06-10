package leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<String, Integer> dp = new HashMap<>();

        return helper(price, special, needs, dp);
    }


    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs,  Map<String, Integer> dp) {
        if (allZeros(needs) || allZeros(price)) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        String key = getKey(needs);
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        for (List<Integer> offer : special) {
            if (isValidOffer(offer, needs)) {
                modifyNeeds(false, offer, needs);
                int taken = offer.get(offer.size() - 1) + helper(price, special, needs, dp);
                modifyNeeds(true, offer, needs);
                minCost = Math.min(minCost, taken);
            }
        }
        if (minCost == Integer.MAX_VALUE){
            minCost = 0;
            for (int i = 0; i < needs.size(); i++) {
                minCost += price.get(i) * needs.get(i);
            }
        }

        dp.put(key, minCost);

        return minCost;
    }


    private void modifyNeeds(boolean add, List<Integer> offer, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (add) {
                needs.set(i, needs.get(i) + offer.get(i));
            } else {
                needs.set(i, needs.get(i) - offer.get(i));
            }
        }
    }

    private boolean allZeros(List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    private String getKey(List<Integer> needs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < needs.size(); i++) {
            sb.append(needs.get(i));
        }
        return sb.toString();
    }

    private boolean isValidOffer(List<Integer> offer, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (offer.get(i) > needs.get(i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new ShoppingOffers().shoppingOffers(Arrays.asList(2, 5), Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10)), Arrays.asList(3, 2)));
    }
}
