package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseLL2 {
    public ListNode reverseBetween(ListNode A, int B, int C) {

        boolean foundB = false, foundC = false;

        ListNode tempHead = A, nodeB = null,
                nodeC = null, prevB = null, afterC = null, prev = null;

        int count = 0;
        while (!(foundB && foundC) && tempHead != null) {
            if (!foundC && count == C) {
                foundC = true;
                nodeC = tempHead;
                afterC = nodeC.next;
            }
            if (!foundB && count == B) {
                foundB = true;
                nodeB = tempHead;
                prevB = prev;
            }
            prev = tempHead;
            tempHead = tempHead.next;
            count++;
        }

        if(nodeB == nodeC || (nodeB == null) || nodeC == null){
            return A;
        }

        tempHead = nodeB;
        if(prevB != null){
            prevB.next = null;
        }
        nodeC.next = null;

        ListNode nodeN = null;
        while (tempHead != null) {
            ListNode temp = tempHead.next;
            tempHead.next = nodeN;
            nodeN = tempHead;
            tempHead = temp;
        }

        if(prevB != null){
            prevB.next = nodeC;
        }

        nodeB.next = afterC;

        return prevB == null ? nodeC : A;
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
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);

        System.out.println(new ReverseLL2().reverseBetween(l ,4, 5));
    }
}
