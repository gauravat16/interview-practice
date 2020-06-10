package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class JumpGame {

    public boolean canJump(int[] nums) {

        if (nums.length <= 1) {
            return true;
        }
        List<Integer> zeros = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros.add(i);
            }
        }

        if (zeros.size() == 0) {
            return true;
        }
        int zeroIdx = 0;
        for (int i = 0; i < nums.length; ) {

            if (nums[i] >= nums.length - 1) {
                return true;
            }

            int maxIdx = -1, maxVal = 0;
            for (int j = 1; j <= nums[i] && j+i < nums.length; j++) {
                if (nums[i+j] >= maxVal) {
                    maxVal = nums[i+j];
                    maxIdx = i+j;
                }
            }

            if(maxVal == 0){
                return maxIdx == nums.length-1;
            }


            while (zeroIdx < zeros.size() && i + maxVal > zeros.get(zeroIdx)) {
                zeroIdx++;
            }

            i += maxVal;
            if (zeroIdx > zeros.size() - 1) {
                return true;
            }
        }

        return false;

    }


    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{1,1,1,0}));
    }
}
