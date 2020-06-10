package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateMat {

    public void rotate(List<List<Integer>> A) {


        int layer = A.get(0).size() / 2, n = A.size() - 1;
        int i = 0;
        while (i < layer) {
            for (int j = i; j < n - i; j++) {
                int temp = A.get(i).get(j);
                A.get(i).set(j, A.get(n - j).get(i));
                A.get(n - j).set(i, A.get(n - i).get(n - j));
                A.get(n - i).set(n - j, A.get(j).get(n-i));
                A.get(j).set(n-i, temp);
            }

            i++;
        }

    }


    public static void main(String[] args) {

        //[7 4 1 ] [8 5 2 ] [9 6 3 ]
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        List<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        row2.add(6);

        List<Integer> row3 = new ArrayList<>();
        row3.add(7);
        row3.add(8);
        row3.add(9);

        List<List<Integer>> mat = new ArrayList<>();
        mat.add(row1);
        mat.add(row2);
        mat.add(row3);

        new RotateMat().rotate(mat);
        System.out.println(mat);
    }
}
