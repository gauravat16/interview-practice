package leetcode.ll;

import interviewbit.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


    private LinkedList ll;
    private int capacity;
    private Map<Integer, LinkedList.ListNode> kvMap;

    public LRUCache(int capacity) {
        ll = new LinkedList();
        kvMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!kvMap.containsKey(key)) {
            return -1;
        }

//        System.out.println(kvMap);

        LinkedList.ListNode node = kvMap.get(key);
        if(ll.head.next == node) return node.value;
        kvMap.remove(node.key);
        ll.removeNode(node);
//        ll.printLL();

        ll.addToFirst(node);
//        ll.printLL();

        kvMap.put(node.key, node);

        return kvMap.get(key).value;
    }

    public void put(int key, int value) {
        if (kvMap.containsKey(key)) {
            LinkedList.ListNode node = kvMap.get(key);
            node.value = value;
            ll.removeNode(node);
            ll.addToFirst(node);
        } else {
            if (kvMap.size() == capacity) {
                LinkedList.ListNode node = ll.removeFromLast();
                kvMap.remove(node.key);
            }
            kvMap.put(key, ll.addToFirst(key, value));
        }
        ll.printLL();

    }

    class LinkedList {

        private ListNode head;
        private ListNode tail;

        public LinkedList() {
            this.head = new ListNode(-1, -1, null, null);
        }

        class ListNode {
            int value;
            int key;
            ListNode next;
            ListNode prev;

            public ListNode(int key, int value, ListNode next, ListNode prev) {
                this.value = value;
                this.next = next;
                this.prev = prev;
                this.key = key;
            }

            @Override
            public String toString() {
                return "{" +
                        "kv [" + key + "," + value + "]" +
                        ", next=" + (next == null ? null : next.value) +
                        ", prev=" + (prev == null ? null : prev.value) +
                        '}';
            }
        }

        public ListNode addToFirst(int key, int val) {
            ListNode node = head.next;
            head.next = new ListNode(key, val, node, head);
            if (node != null) node.prev = head.next;
            if (tail == null || tail == head) tail = head.next;
            return head.next;
        }

        public ListNode addToFirst(ListNode newNode) {
            ListNode node = head.next;
            newNode.prev = head;
            newNode.next = node;
            head.next = newNode;
            if (node != null) node.prev = head.next;
            if (tail == null || tail == head) tail = head.next;
            return head.next;
        }

        public ListNode removeFromLast() {
            if (tail != null) {
                ListNode node = tail;
                tail = tail.prev;
                tail.next = null;
                return node;
            }
            return null;
        }

        public void removeNode(ListNode node) {
            if (node == tail) {
                removeFromLast();
            } else {
                node.prev.next = node.next;
                if (node.next != null) {
                    node.next.prev = node.prev;
                }
            }

            node.next = null;
            node.prev = null;

        }

        public void printLL() {
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp);
                temp = temp.next;
            }

            System.out.println();
        }

    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);

        //String commands = "S 12 5 G 3 S 13 6 G 14 S 5 9 G 5 S 13 10 S 14 5 S 15 13 S 5 8 S 7 8 S 3 3 G 2 S 5 10 S 14 4 S 3 15 S 13 10 G 14 S 5 15 G 3 S 3 15 G 8 G 8 G 11 G 12 S 6 11 S 15 11 S 7 7 S 10 13 G 13 G 12 G 2 G 1 G 1 G 2 S 6 5 S 6 8 S 14 12 G 5 G 7 S 5 11 S 9 5";


        //String commands = "S 2 1 G 2 S 3 2 G 2 G 3";

        String commands = "S 5 13 S 9 6 S 4 1 G 4 S 6 1 S 8 11 G 13 G 1 S 12 12 G 10 S 15 13 S 2 13 S 7 5 S 10 3 G 6 G 10 S 15 14 S 5 12 G 5 G 7 G 15 G 5 G 6 G 10 S 7 13 G 14 S 8 9 G 4 S 6 11 G 9 S 6 12 G 3";

        String lcComm1 = "S 1 1 S 2 2 S 3 3 S 4 4 G 4 G 3 G 2 G 1 S 5 5 G 1 G 2 G 3 G 4 G 5";
        String lcComm = "S 2 1 S 1 1 S 2 3 S 4 1 G 1 G 2";

        String[] cmds = lcComm.split(" ");

        for (int i = 0; i < cmds.length; ) {
            String cmd = cmds[i];

            if (cmd.equals("S")) {
                int key = Integer.parseInt(cmds[++i]);
                int value = Integer.parseInt(cmds[++i]);
                System.out.println("Set (" + key + "," + value + ")");
                lru.put(key, value);
            } else if (cmd.equals("G")) {
                int key = Integer.parseInt(cmds[++i]);
                System.out.println("Get (" + key + ")");
                System.out.println(lru.get(key));
            }
            i++;
        }

        // -1 -1 9 -1 4 15 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 7

    }
}
