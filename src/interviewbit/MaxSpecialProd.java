package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSpecialProd {

    public int maxSpecialProduct(List<Integer> A) {

        long[] left = new long[A.size()];
        left[0] = 0;
        long[] right = new long[A.size()];
        right[A.size() - 1] = 0;

        for (int i = 1; i < A.size(); i++) {
            if (A.get(i - 1) > A.get(i)) {
                left[i] = i - 1;
            } else {
                long index = left[i - 1];
                while (index > 0) {
                    if (A.get((int) index) > A.get(i)) {
                        left[i] = index;
                        break;
                    }
                    index = left[(int) index];
                }

            }
        }

        for (int i = A.size() - 2; i >= 0; i--) {
            if (A.get(i + 1) > A.get(i)) {
                right[i] = i + 1;
            } else {
                long index = right[i + 1];
                while (index > 0) {
                    if (A.get((int) index) > A.get(i)) {
                        right[i] = index;
                        break;
                    }
                    index = right[(int) index];
                }
            }
        }

        long maxProd = 0;

        for (int i = 0; i < A.size(); i++) {

            long prod = (left[i] * right[i]) % 1000000007;

            maxProd = Math.max(prod, maxProd);
        }

        return (int) maxProd;

    }

    public static void main(String[] args) {
        System.out.println(new MaxSpecialProd().maxSpecialProduct(Arrays.asList(6, 5, 4, 9, 9, 6, 5, 4, 5, 9, 9)));
    }
}
