package leetcode.array;

import java.util.Arrays;

public class XorTriplets {

    public int countTriplets(int[] arr) {


        int[] prefix = new int[arr.length+1];

        prefix[0] = 0;

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = arr[i-1] ^ prefix[i-1];
        }

        int count = 0;

        System.out.println(Arrays.toString(prefix));

        for (int s = 0; s < prefix.length; s++) {
            for (int m = s + 1; m < prefix.length; m++) {
                for (int e = m + 1; e < prefix.length; e++) {
                    int a = prefix[m] ^ prefix[s];
                    int b = prefix[m] ^ prefix[e];

                    if (a == b) {
                        count++;
                    }
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(new XorTriplets().countTriplets(new int[]{1,1,1,1,1}));
    }
}
