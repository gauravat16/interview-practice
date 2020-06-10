package leetcode.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStringChain {


    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (String s : words) {
            set.add(s);
        }

        int max = 1;

        for (String s : words) {
            max = Math.max(max, helper(set, dp, s));
        }

        return max;
    }

    private int helper(Set<String> set, Map<String, Integer> dp, String s) {

        if (dp.containsKey(s)) {
            return dp.get(s);
        }

        int max = 1;
        String tmp;
        for (int i = 0; i < s.length(); i++) {
            tmp = s.substring(0, i) + s.substring(i + 1);

            if (set.contains(tmp)) {
                max = Math.max(max, helper(set, dp, tmp) + 1);
            }
        }

        dp.put(s, max);

        return max;
    }


    public static void main(String[] args) {
        System.out.println(new LongestStringChain().longestStrChain(new String[]{"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"}));
    }

}
