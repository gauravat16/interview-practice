package interviewbit;

import java.util.*;

public class ThreeSumClosest {

    public int threeSumClosest(List<Integer> a, int b) {

        Map<Integer,List<Integer>> cache = new HashMap<>();

        for(int i=0; i<a.size(); i++){
            for(int j=i; j<a.size(); j++){
                if(i==j){
                    continue;
                }

                cache.put(a.get(i)+a.get(j), Arrays.asList(i,j));
            }
        }
        int closest = Integer.MAX_VALUE;

        for(int i=0; i<a.size(); i++){
            for(Map.Entry<Integer, List<Integer>> e : cache.entrySet()){
                if(i == e.getValue().get(0) || i == e.getValue().get(1)){
                    continue;
                }
                int sum =  a.get(i) + e.getKey();

                if(closest == Integer.MAX_VALUE){
                    closest = sum;
                }else if(Math.abs(b - closest) > Math.abs(b - sum)){
                    closest = sum;
                }

            }

        }


        return closest;

    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(Arrays.asList(2, 1, -9, -7, -8, 2, -8, 2, 3, -8), -1));
    }
}
