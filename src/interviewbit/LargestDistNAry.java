package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDistNAry {

    int maxPath = 0;

    public int solve(List<Integer> A) {
        if (A.size() == 1) {
            return 0;
        }

        if (A.size() == 2) {
            return 1;
        }

        int root = -1;
        for (int i = 0; i < A.size(); i++) {

            if (A.get(i) == -1) {
                dfs(A, i);
                break;
            }
        }


        return maxPath;

    }

    private int dfs(List<Integer> A, int root) {
        int max = 0;
        int max1 = 0, max2 = 0;
        List<Integer> vals = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {

            if (A.get(i) == root) {
                int curr = dfs(A, i) + 1;
                max = Math.max(max, curr);
                vals.add(curr);
                if (max1 < curr) {
                    max2 = max1;
                    max1 = curr;

                }
                else if (max2 < curr) {
                    max2 = curr;
                }
            }
        }
        System.out.println(vals);
//        Collections.sort(vals, (a, b) -> b-a);
        System.out.println(max1 +"-- " + max2);

//        if(vals.size()>1) {
//            maxPath = Math.max(maxPath, vals.get(0) + vals.get(1));
//        }else if(vals.size() == 1){
//            maxPath = Math.max(maxPath, vals.get(0));
//        }

       maxPath = Math.max(maxPath, max1 + max2);
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(new LargestDistNAry().solve(Arrays.asList(-1, 0, 0, 1, 2, 1, 5))); //5
//         System.out.println(new LargestDistNAry().solve(Arrays.asList(-1, 0)));
//         System.out.println(new LargestDistNAry().solve(Arrays.asList(-1, 0, 0, 0, 3)));
        //System.out.println(new LargestDistNAry().solve(Arrays.asList(-1, 0, 0, 2, 1, 2, 4, 4, 2, 5, 5, 1, 1, 2, 4, 13, 7, 0, 2, 9, 2, 16, 18, 0, 13, 13, 22, 10, 8, 3, 26, 14, 24, 0, 26, 0, 8, 15, 6, 22, 20, 30, 1, 2, 10, 0, 39, 3, 8, 40, 9, 12, 42, 37, 39, 47, 52, 24, 29, 48, 15, 18, 50, 46, 43, 55, 26, 1, 6, 28, 59, 51, 56, 4, 53, 30, 5, 54, 18, 29, 3, 65, 30, 16, 9, 22, 14, 30, 32, 62, 0, 6, 44, 18, 37, 14, 80, 93, 2, 95))); //11
         System.out.println(new LargestDistNAry().solve(Arrays.asList(-1, 0, 1, 1, 2, 0, 5, 0, 3, 0, 0, 2, 3, 1, 12, 14, 0, 5, 9, 6, 16, 0, 13, 4, 17, 2, 1, 22, 14, 20, 10, 17, 0, 32, 15, 34, 10, 19, 3, 22, 29, 2, 36, 16, 15, 37, 38, 27, 31, 12, 24, 29, 17, 29, 32, 45, 40, 15, 35, 13, 25, 57, 20, 4, 44, 41, 52, 9, 53, 57, 18, 5, 44, 29, 30, 9, 29, 30, 8, 57, 8, 59, 59, 64, 37, 6, 54, 32, 40, 26, 15, 87, 49, 90, 6, 81, 73, 10, 8, 16 )));
        //System.out.println(new LargestDistNAry().solve(Arrays.asList(-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 8, 37, 11, 14, 27, 90, 5, 11, 86, 91)));
         System.out.println(new LargestDistNAry().solve(Arrays.asList(-1, 2, 0)));



    }
}
