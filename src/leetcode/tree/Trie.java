package leetcode.tree;

import java.util.Arrays;

public class Trie {


    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode('0');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] arr = word.toCharArray();

        TrieNode tempNode = root;

        for (char c : arr) {
            if (!tempNode.hasChild(c)) {
                tempNode.add(c);
            }
            tempNode = tempNode.getChild(c);
        }

        tempNode.setEnd(true);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return getPrefix(prefix) != null;
    }

    class TrieNode {
        private char c;
        private TrieNode[] children;
        private boolean end;

        public TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
        }

        public TrieNode add(char c) {
            children[c - 'a'] = new TrieNode(c);
            return children[c - 'a'];
        }

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        public boolean hasChild(char c) {
            return getChild(c) != null;
        }

        public boolean isEnd() {
            return end;
        }

        public void setEnd(boolean end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return "{" +
                    "c=" + c +
                    ", children=" + Arrays.toString(children) +
                    '}';
        }
    }

    public void traverseTrie() {
        for (TrieNode t : root.children) {
            traverseTrie(t, new StringBuilder());
        }
    }

    public boolean search(String s) {

        TrieNode temp = getPrefix(s);
        return temp != null && temp.isEnd();
    }

    private TrieNode getPrefix(String s) {
        TrieNode temp = root;

        for (char c : s.toCharArray()) {
            if (temp.hasChild(c)) {
                temp = temp.getChild(c);
            } else {
                return null;
            }
        }

        return temp;
    }


    private void traverseTrie(TrieNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.c);
        if (root.isEnd()) {
            System.out.println(sb);
        }

        for (TrieNode node : root.children) {
            if (node != null) {
                traverseTrie(node, sb);
            }
        }

        sb.setLength(sb.length() - 1);

    }


    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("gaurav");
        trie.insert("gauravs");
        trie.insert("auroot");
        trie.insert("game");


        System.out.println(trie.root);

        trie.traverseTrie();

        System.out.println(trie.search("dsada"));
        System.out.println(trie.search("gauravs"));


    }
}
