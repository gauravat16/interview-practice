package interviewbit;

import java.util.*;

public class Equal {


    public ArrayList<Integer> equal(List<Integer> A) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> returnList = Arrays.asList(A.size(), A.size(), A.size(), A.size());

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (map.containsKey(A.get(i) + A.get(j))) {
                    List<Integer> prev = map.get(A.get(i) + A.get(j));
                    boolean prevMatch = (returnList.get(0) > prev.get(0)) ||
                            (returnList.get(1) > prev.get(1)) ||
                            (returnList.get(2) > i) ||
                            (returnList.get(3) > j);
                    if (prev.get(0) < i && prev.get(1) != j && prev.get(1) != i
                            && prevMatch) {
                        returnList = Arrays.asList(prev.get(0), prev.get(1), i, j);
                    }
                }

                if (!map.containsKey(A.get(i) + A.get(j))) {
                    map.put(A.get(i) + A.get(j), Arrays.asList(i, j));
                }

            }
        }

        return returnList.get(0) == A.size() ? new ArrayList<>() : new ArrayList<>(returnList);
    }


    public static void main(String[] args) {
        System.out.println(new Equal().equal(Arrays.asList(0, 0, 1, 0, 2, 1)));
    }
}
