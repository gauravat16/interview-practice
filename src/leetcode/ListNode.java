package leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "leetcode.ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}