package interviewbit;

import java.util.*;

public class LongestZeroSumArr {


    public ArrayList<Integer> lszero(List<Integer> A) {

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int start = 0, end = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);

            if(A.get(i) == 0){
                start = end =i;
            }

            if (map.containsKey(sum)) {

                if (i - (map.get(sum) + 1) > end - start) {
                    start = map.get(sum) + 1;
                    end = i;
                }

            } else {
                map.put(sum, i);
            }


        }

        ArrayList<Integer> res = new ArrayList<>();

        if(start == end && A.get(start) != 0){
            return res;
        }
        for (int i = start; i <= end; i++) {
            res.add(A.get(i));
        }

        return res;


    }


    public static void main(String[] args) {
        System.out.println(new LongestZeroSumArr().lszero(Arrays.asList(10, 13, -1, 8, 29, 1, 24, 8, 21, 20, 21, -23, -21, 0)));
    }
}
