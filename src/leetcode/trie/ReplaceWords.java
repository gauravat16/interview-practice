package leetcode.trie;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {

    public String replaceWords(List<String> dict, String sentence) {

        TrieNode root = Trie.buildTrie(dict);

        StringBuilder sb = new StringBuilder();

        for (String s : sentence.split(" ")) {
            sb.append(Trie.getRoot(root, s)).append(" ");
        }

        return sb.toString().trim();

    }


    static class Trie {

        public static TrieNode buildTrie(List<String> dict) {

            TrieNode root = new TrieNode('0');

            TrieNode curr = root;
            for (String s : dict) {
                for (char c : s.toCharArray()) {
                    TrieNode child = curr.getChild(c);
                    if (child == null) {
                        curr = curr.insertChild(c);
                    } else {
                        curr = child;
                    }
                }
                curr.isWord = true;
                curr = root;
            }

            return root;
        }

        public static String getRoot(TrieNode root, String s) {
            StringBuilder sb = new StringBuilder();
            TrieNode curr = root;

            for (int i = 0; i < s.length(); ) {

                TrieNode child = curr.getChild(s.charAt(i));
                if (child == null) {
                    return s;
                } else {
                    sb.append(s.charAt(i));
                    if (child.isWord) {
                        return sb.toString();
                    }
                    curr = child;
                    i++;
                }
            }

            return s;
        }
    }

    static class TrieNode {
        private TrieNode[] children;
        private char val;
        private boolean isWord;

        public TrieNode(char c) {
            this.val = c;
            this.children = new TrieNode[26];
        }

        public TrieNode insertChild(char c) {
            children[c - 'a'] = new TrieNode(c);
            return children[c - 'a'];
        }

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceWords().replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }
}
