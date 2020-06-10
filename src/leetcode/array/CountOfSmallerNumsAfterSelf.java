package leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CountOfSmallerNumsAfterSelf {

    class Pair {
        int num;
        int index;

        public Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {

        int[] counts = new int[nums.length];

        Pair[] elems = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            elems[i] = new Pair(nums[i], i);
        }

        mergeSort(elems, counts, 0, nums.length - 1);

        List<Integer> ret = new ArrayList<>();

        for (int i : counts) {
            ret.add(i);
        }
        return ret;

    }


    void mergeSort(Pair[] nums, int[] counts, int s, int e) {

        if (s < e) {
            int mid = s + (e - s) / 2;

            mergeSort(nums, counts, s, mid);
            mergeSort(nums, counts, mid + 1, e);


            int i = s, j = mid + 1, lesserNumbers = 0;
            LinkedList<Pair> sorted = new LinkedList<>();

            while (i <= mid && j <= e) {
                if (nums[i].num > nums[j].num) {
                    sorted.add(nums[j]);
                    lesserNumbers++;
                    j++;
                } else {
                    sorted.add(nums[i]);
                    counts[nums[i].index] += lesserNumbers;
                    i++;
                }
            }

            while (i <= mid) {
                counts[nums[i].index] += lesserNumbers;
                sorted.add(nums[i++]);
            }

            while (j <= e) {
                sorted.add(nums[j++]);
            }

            i = s;
            for (Pair p : sorted) {
                nums[i++] = p;
            }
        }


    }


    public static void main(String[] args) {
        System.out.println(new CountOfSmallerNumsAfterSelf().countSmaller(new int[]{5, 2, 6, 1}));
    }
}
