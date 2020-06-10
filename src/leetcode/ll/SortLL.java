package leetcode.ll;

import leetcode.ListNode;

import java.util.List;

public class SortLL {

    public ListNode sortList(ListNode head) {
       return megeSort(head, null);
    }

    private ListNode megeSort(ListNode start, ListNode end) {

        if (start == end || start.next == null) {
            return start;
        }

        ListNode mid = null, prev = null;

        ListNode slow = start;
        ListNode fast = start;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (fast == end) {
                break;
            }
        }
        mid = slow;
        if (prev != null) {
            prev.next = null;
        }
        ListNode l = megeSort(start, prev);
        ListNode r = megeSort(mid, end);

        return merge(l, r);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode returnNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        while (l1 != null) {
            dummy.next = l1;
            l1 = l1.next;
            dummy = dummy.next;
        }

        while (l2 != null) {
            dummy.next = l2;
            l2 = l2.next;
            dummy = dummy.next;
        }

        return returnNode.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(7);
        listNode.next.next.next.next = new ListNode(10);

        System.out.println(new SortLL().sortList(listNode));

    }

}
