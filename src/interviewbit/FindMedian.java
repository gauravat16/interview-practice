package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMedian {

    public int findMedian(ArrayList<ArrayList<Integer>> A) {

        int max = 0, min = 0, elems = A.size() * A.get(0).size();

        for (ArrayList<Integer> l : A) {
            max = Math.max(l.get(l.size()), max);
            min = Math.min(l.get(0), min);
        }

        int elemsLessThanMedian = (elems) / 2 + 1;
        while (min < max) {
            int mid = (max - min) / 2;
            int count = 0;

            for (ArrayList<Integer> l : A) {
                int index = Collections.binarySearch(l, mid);

                if (index < 0) {
                    index = Math.abs(index) - 1;
                } else {
                    while (count < l.size() && l.get(index) == mid) {
                        index++;
                    }
                }
                count += index;
            }
            if (count < elemsLessThanMedian) {
                min = mid + 1;
            } else {
                max = mid;
            }

        }

        return min;
    }

    private int binarySearch(List<Integer> l, int val) {
        int s = 0, e = l.size() - 1;
        while (s <= e) {
            int mid = (s + e) / 2;

            if (l.get(mid) == val) {
                return mid;
            }
            if (l.get(mid) > val) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return -s - 1;
    }

    public static void main(String[] args) {

        System.out.println(new FindMedian().binarySearch(Arrays.asList(1,2,3,4,5,7,8,9), 6));
        System.out.println(Collections.binarySearch(Arrays.asList(1,2,3,4,5,7,8,9), 106));


    }
}
