package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int ptr1 = j + 1, ptr2 = nums.length - 1;
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (ptr1 < ptr2) {
                    int sum = nums[i] + nums[j] + nums[ptr1] + nums[ptr2];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[ptr1], nums[ptr2]));
                        while (ptr1 < ptr2 && nums[ptr1] == nums[ptr1 + 1]) {
                            ptr1++;
                        }
                        while (ptr1 < ptr2 && nums[ptr2] == nums[ptr2 - 1]) {
                            ptr2--;
                        }
                        ptr1++;
                        ptr2--;
                    } else if (sum < target) {
                        ptr1++;
                    } else {
                        ptr2--;
                    }
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[]{0, 0, 0, 0, 0}, 0));
    }
}
