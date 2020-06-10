package leetcode.dp;

import java.util.*;

public class WordLadderI {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int level = 1;
        while (!q.isEmpty()) {

            int size = q.size();

            for (int k = 0; k < size; k++) {
                String word = q.poll();
                if (word.equals(endWord)) return level;

                for (int j = 0; j < word.length(); j++) {
                    char[] s1 = word.toCharArray();
                    for (char i = 'a'; i <= 'z'; i++) {
                        s1[j] = i;
                        String w = new String(s1);
                        if (dict.remove(w)) {
                            q.offer(w);
                        }
                    }
                }
            }
            level++;
        }

        return 0;

    }

    public static void main(String[] args) {
        System.out.println(new WordLadderI().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log","cog")));
    }

}
