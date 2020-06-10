package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReorderLog {

    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> {

            String s1 = String.join(" ", Arrays.copyOfRange(a, 1, a.length));
            String s2 = String.join(" ", Arrays.copyOfRange(b, 1, b.length));

            int sum =  s1.compareToIgnoreCase(s2);

            if (sum == 0) {
                return a[0].compareToIgnoreCase(b[0]);
            }

            return sum;

        });

        List<String> ints = new ArrayList<>();
        for (String line : logLines) {
            String[] lineArr = line.split(" ");
            if(lineArr[1].charAt(0) =='-' || (lineArr[1].charAt(0) >= '0' && lineArr[1].charAt(0) <= '9')){
                ints.add(line);
            }else{
                pq.offer(lineArr);
            }

        }

        List<String> lines = new ArrayList<>();

        while (!pq.isEmpty()) {
            lines.add(String.join(" ", pq.poll()));
        }
        lines.addAll(ints);
        return lines;
    }

    public static void main(String[] args) {

        System.out.println("999a".compareTo("a1"));
        System.out.println(new ReorderLog().reorderLines(6, Arrays.asList(
                "f3 52 54 31",
                "w1 has uni gry",
                "br8 eat nim did",
                "t2 13 121 98",
                "r1 box ape bit",

                "b4 xi me nu")));
    }
}
