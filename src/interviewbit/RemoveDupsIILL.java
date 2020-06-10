package interviewbit;

public class RemoveDupsIILL {

    public ListNode deleteDuplicates(ListNode A) {

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode retnode = dummy;
        ListNode prev = null;
        while (A != null) {
            if ((A.next == null || A.val != A.next.val) &&
                    (prev == null || prev.val != A.val)) {
                dummy.next = A;
                dummy = dummy.next;
                prev = A;
                A = A.next;
                dummy.next = null;

            } else {
                prev = A;
                A = A.next;
            }


        }

        return retnode.next;
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
        ListNode l = new ListNode(1);
        l.next = new ListNode(1);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(4);
        l.next.next.next.next.next = new ListNode(5);

        System.out.println(new RemoveDupsIILL().deleteDuplicates(l));
    }
}
