package interviewbit;

import java.util.List;

public class SubstractLL {

    public ListNode subtract(ListNode A) {

        ListNode slow = A, fast = A, limit = null;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next == null) {
            //ODD
            limit = slow;
        } else {
            //EVEN
            limit = slow.next;

        }

        ListNode second = reverseLL(slow.next);
        ListNode tempSecond = second;
        ListNode first = A;
        while (first != limit) {
            first.val = second.val - first.val;
            first = first.next;
            second = second.next;
        }
        second = reverseLL(tempSecond);
        slow.next = second;

        return A;
    }

    private ListNode reverseLL(ListNode node) {
        ListNode prev = null;

        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }

        return prev;

    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
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

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
//        listNode.next.next.next.next.next = new leetcode.ListNode(6);
        System.out.println(new SubstractLL().subtract(listNode));
    }
}
