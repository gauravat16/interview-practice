package interviewbit;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int s = i + 1, e = nums.length - 1;

                while (s < e) {
                    int sum = nums[i] + nums[s] + nums[e];
                    if (sum == 0) {
                        triplets.add(Arrays.asList(nums[i], nums[s], nums[e]));
                        s++;
                        e--;
                        while (s < e && nums[s] == nums[s + 1]) {
                            s++;
                        }
                        while (s < e && nums[e] == nums[e - 1]) {
                            e--;
                        }
                    } else if (sum < 0) {
                        s++;
                    } else {
                        e--;
                    }

                }
            }
        }

        return triplets;

    }

    public static void main(String[] args) {
//        System.out.println(new ThreeSum().threeSum(new int[]{1, 1, -2}));
//        System.out.println(new ThreeSum().threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(new ThreeSum().threeSum(new int[]{1, -1, -1, 0}));


    }
}
