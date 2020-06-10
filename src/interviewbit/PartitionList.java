package interviewbit;

public class PartitionList {

    public ListNode partition(ListNode A, int B) {

        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode orignial = A;

        ListNode tempLess = less, tempMore = more, partition = null;

        while (A != null) {
            if (A.val >= B) {
                tempMore.next = A;
                A = A.next;
                tempMore = tempMore.next;
                tempMore.next = null;

            } else if (A.val < B) {
                tempLess.next = A;
                A = A.next;
                tempLess = tempLess.next;
                tempLess.next = null;
            }

        }

        tempLess.next = more.next;

        return less.next;

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
        ListNode l = new ListNode(4);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(1);
        l.next.next.next.next = new ListNode(5);

        System.out.println(new PartitionList().partition(l, 1));

    }
}
