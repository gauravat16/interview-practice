package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AntiDiagonal {


    public ArrayList<ArrayList<Integer>> diagonal(List<List<Integer>> a) {
        ArrayList<ArrayList<Integer>> diagonals = new ArrayList<>();

        int row = 0, col = 0, offset = 0;
        boolean bottom = false;

        while (diagonals.size() < 2*a.size()-1) {
            ArrayList<Integer> diagonal = new ArrayList<>();

            int i =  offset;
            int j = col;

            while (i <= row && j >= 0) {
                diagonal.add(a.get(i).get(j));
                j--;
                i++;
            }

            diagonals.add(diagonal);

            if (row == a.size() - 1 && col == a.get(row).size() - 1 && !bottom) {
                offset = 1;
                bottom = true;
            } else if (!bottom) {
                row++;
                col++;
            } else {
                offset++;
            }
        }

        return diagonals;
    }

    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<List<Integer>> l = new ArrayList<>();


        for (int[] a : arr) {
            List<Integer> al = new ArrayList<>();
            for (int i : a) {
                al.add(i);
            }
            l.add(al);
        }

        System.out.println(new AntiDiagonal().diagonal(l));
    }
}
