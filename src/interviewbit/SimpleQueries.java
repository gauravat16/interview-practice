package interviewbit;

import java.util.*;

public class SimpleQueries {

    public ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {

        List<Integer> g = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            for (int j = i; j < A.size(); j++) {
                g.add(getProductOfDivisiors(Collections.max(A.subList(i, j+1))));
            }
        }

        Collections.sort(g, (a, b) -> b - a);

        ArrayList<Integer> x = new ArrayList<>();

        for (int i = 0; i < B.size(); i++) {
            x.add(g.get(B.get(i) -1));
        }

        return x;
    }

    private int getProductOfDivisiors(int num) {
        long prod = 1;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if(num/i == i){
                    prod = (prod % 1000000007) * i;
                }else {
                    prod = (prod % 1000000007) * i * num/i;
                }

            }
        }

        return (int) (prod % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new SimpleQueries().solve(Arrays.asList(39, 99, 70, 24, 49, 13, 86, 43, 88, 74, 45, 92, 72, 71, 90, 32, 19, 76, 84, 46, 63, 15, 87, 1, 39, 58, 17, 65, 99, 43, 83, 29, 64, 67, 100, 14, 17, 100, 81, 26, 45, 40, 95, 94, 86, 2, 89, 57, 52, 91, 45)
                , Arrays.asList(1221, 360, 459, 651, 958, 584, 345, 181, 536, 116, 1310, 403, 669, 1044, 1281, 711, 222, 280, 1255, 257, 811, 409, 698, 74, 838)));

//        System.out.println(new SimpleQueries().getProductOfDivisiors(100));
    }
}
