package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {

        int currIdx = 0, currDir = 0;
        Set<Integer> idxSet = new HashSet<>();

        while (true) {
            if (idxSet.contains(currIdx)) {
                return true;
            }
            int nextDir = nums[currIdx] < 0 ? -1 : 1;
            idxSet.add(currIdx);

            if (currDir != 0 && currDir != nextDir) {
                if (idxSet.contains(getIndex(currIdx, nums))) {
                    return false;
                }
                idxSet.clear();
                idxSet.add(currIdx);
                currIdx = getIndex(currIdx, nums);

            } else {
                currIdx = getIndex(currIdx, nums);
            }
            currDir = nextDir;
        }
    }

    int getIndex(int idx, int[] nums) {
        int val = nums[idx];

        if (val > 0) {
            if (idx + val < nums.length) {
                return idx + val;
            } else {
                return (idx + val) % nums.length;
            }
        } else {
            if (idx + val >= 0) {
                return idx + val;
            } else {
                return nums.length + ((idx + val) % nums.length) -1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{-1,-2,-3,-4,-5}));

    }
}
