package leetcode.string;

import java.util.*;

public class ReorganizeString {

    public String reorganizeString(String S) {
        Map<Character, Integer> count = new HashMap<>();

        for (char c : S.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            int diff = b[1] - a[1];
            if(diff == 0){
                return a[0]-b[0];
            }

            return diff;
        });

        for (Map.Entry<Character, Integer> e: count.entrySet()) {
            if(e.getValue() > (S.length()+1)/2) return "";

            q.offer(new int[]{e.getKey(), e.getValue()});
        }

        StringBuilder sb = new StringBuilder();


        while(q.size()>=2){
            int[] c1 = q.poll();
            int[] c2 = q.poll();

            sb.append((char)(c1[0]));
            sb.append((char)(c2[0]));

            if(--c1[1] > 0) q.offer(c1);
            if(--c2[1] > 0) q.offer(c2);
        }

        if(q.size()>0){
            sb.append((char)q.poll()[0]);
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReorganizeString().reorganizeString("ogccckcwmbmxtsbmozli"));
    }

}
