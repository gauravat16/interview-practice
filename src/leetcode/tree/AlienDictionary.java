package leetcode.tree;

import java.util.*;

public class AlienDictionary {

    public String printOrder(String[] words, int k) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Set<Character>> dependencies = new HashMap<>();

        for (String w : words) {
            for (char c : w.toCharArray()) {
                dependencies.put(c, new HashSet<>());
                countMap.put(c, 0);

            }
        }

        for (int w = 0; w < words.length - 1; w++) {
            String w1 = words[w];
            String w2 = words[w + 1];

            int i = 0, j = 0;
            while (i < w1.length() && j < w2.length()) {
                if (w1.charAt(i) != w2.charAt(j)) {
                    countMap.put(w2.charAt(j), countMap.getOrDefault(w2.charAt(j), 0) + 1);

                    Set<Character> l = dependencies.get(w1.charAt(i));
                    l.add(w2.charAt(j));
                    dependencies.put(w1.charAt(i), l);
                    break;
                }
                i++;
                j++;
            }
        }

        Queue<Character> q = new LinkedList<>();

        for (Map.Entry<Character, Integer> e : countMap.entrySet()) {
            if (e.getValue() == 0) {
                q.offer(e.getKey());
            }
        }


        while (!q.isEmpty()) {
            char c = q.poll();
            countMap.remove(c);
            sb.append(c);
            if (!dependencies.containsKey(c)) {
                break;
            }
            for (char i : dependencies.get(c)) {
                countMap.put(i, countMap.get(i) - 1);
                if (countMap.get(i) == 0) {
                    q.offer(i);
                }
            }
        }

        return countMap.size() > 0 ? "" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AlienDictionary().printOrder(new String[]{"zy", "zx"}, 4));
    }
}
