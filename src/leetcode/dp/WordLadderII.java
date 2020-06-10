package leetcode.dp;

import java.util.*;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        List<List<String>> all = new ArrayList<>();

        Map<String, List<String>> neighbourMap = new HashMap<>();

        while (!q.isEmpty()) {

            int size = q.size();
            Set<String> currVisted = new HashSet<>();

            boolean found = false;
            for (int l = 0; l < size; l++) {
                String word = q.poll();


                if (word.equals(endWord)) {
                    found = true;
                    break;
                }

                for (String s : getNeighbours(word, dict)) {
                    if (!visited.contains(s)) {
                        neighbourMap.computeIfAbsent(word, k -> new ArrayList<>()).add(s);

                        if (!currVisted.contains(s)) {
                            q.offer(s);
                            currVisted.add(s);
                        }
                    }

                }
            }

            visited.addAll(currVisted);

            if (found) break;
        }

        List<String> curr = new ArrayList<>();
        curr.add(beginWord);
        dfs(beginWord, endWord, curr, all, dict, neighbourMap);

        return all;
    }

    private List<String> getNeighbours(String word, Set<String> set) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] arr = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                String s = new String(arr);

                if (set.contains(s)) {
                    list.add(s);
                }
            }
        }

        return list;
    }


    private void dfs(String s, String endWord, List<String> curr, List<List<String>> all, Set<String> set, Map<String, List<String>> neighbourMap) {

        if (s.equals(endWord)) {
            all.add(new ArrayList<>(curr));
            return;
        }

        if (!neighbourMap.containsKey(s)) return;
        for (String s1 : neighbourMap.get(s)) {
            curr.add(s1);
            set.remove(s1);
            dfs(s1, endWord, curr, all, set, neighbourMap);
            curr.remove(curr.size() - 1);
            set.add(s1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new WordLadderII().findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
