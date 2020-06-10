package interviewbit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Stringoholics {

    public int solve(String[] A) {

        Map<Integer, Integer> count = new HashMap<>();

        for (String s : A) {
            int time = countTriesTillOriginal(s);
            count.put(time, count.getOrDefault(time, 0)+1);
        }

        int max = 0, time = 0;

        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                time = e.getKey();
            }
        }

        return time;
    }

    private int countTriesTillOriginal(String s) {

        StringBuilder sb = new StringBuilder(s);

        int len = 1;
        int count = 0;

        do {

            String temp = sb.substring(len, sb.length()) + sb.substring(0, len);
            sb.setLength(0);
            sb.append(temp);

            if (len == s.length()) {
                len = 1;
            }
            len++;

            count++;

        } while (s.indexOf(sb.toString()) != 0);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Stringoholics().solve(new String[]{"a", "ababa", "aba"}));
    }

}
