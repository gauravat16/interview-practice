package interviewbit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU {

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRU(int capacity) {
        this.capacity = capacity;
        head = new Node(null, null, 0, 0);
        tail = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {

            moveToEnd(key);
            printLL();
            return map.get(key).val;
        }

        return -1;
    }

    private void moveToTop(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            Node currTop = head.next;
            head.next = node;
            node.next = currTop;
        }
    }

    private void moveToEnd(int key) {
        if (map.containsKey(key)) {

            Node node = map.get(key);
            if (tail == node) {
                return;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
            node.next = null;
        }
    }

    private void addAtEnd(int key, int value) {
        tail.next = new Node(null, tail, value, key);
        map.put(key, tail.next);
        tail = tail.next;
    }


    public void set(int key, int value) {

        if (map.containsKey(key)) {
            map.get(key).val = value;
            moveToEnd(key);
        } else {
            if (map.size() + 1 > capacity) {
                Node tempNode = head.next;
                if (tempNode != null) {
                    head.next = tempNode.next;
                    if (tail == tempNode) {
                        tail = tempNode.prev;
                    }
                    head.next.prev = head;
                    map.remove(tempNode.key);
                }
            }
            addAtEnd(key, value);
        }
        printLL();
    }

    private void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp);
            temp = temp.next;
        }

        System.out.println();
    }

    class Node {
        Node next;
        Node prev;
        int val;
        int key;

        public Node(Node next, Node prev, int val, int key) {
            this.next = next;
            this.prev = prev;
            this.val = val;
            this.key = key;
        }

        @Override
        public String toString() {
            return " [" + key + "," + val + "] ";
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU(1);

        //String commands = "S 12 5 G 3 S 13 6 G 14 S 5 9 G 5 S 13 10 S 14 5 S 15 13 S 5 8 S 7 8 S 3 3 G 2 S 5 10 S 14 4 S 3 15 S 13 10 G 14 S 5 15 G 3 S 3 15 G 8 G 8 G 11 G 12 S 6 11 S 15 11 S 7 7 S 10 13 G 13 G 12 G 2 G 1 G 1 G 2 S 6 5 S 6 8 S 14 12 G 5 G 7 S 5 11 S 9 5";


        //String commands = "S 2 1 G 2 S 3 2 G 2 G 3";

        String commands = "S 5 13 S 9 6 S 4 1 G 4 S 6 1 S 8 11 G 13 G 1 S 12 12 G 10 S 15 13 S 2 13 S 7 5 S 10 3 G 6 G 10 S 15 14 S 5 12 G 5 G 7 G 15 G 5 G 6 G 10 S 7 13 G 14 S 8 9 G 4 S 6 11 G 9 S 6 12 G 3";

        String lcComm = "S 2 1 G 2 S 3 2 G 2 G 3";

        String[] cmds = lcComm.split(" ");

        for (int i = 0; i < cmds.length; ) {
            String cmd = cmds[i];

            if (cmd.equals("S")) {
                int key = Integer.parseInt(cmds[++i]);
                int value = Integer.parseInt(cmds[++i]);
                System.out.println("Set (" + key + "," + value + ")");
                lru.set(key, value);
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
