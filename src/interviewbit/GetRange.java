package interviewbit;

import java.util.Arrays;

public class GetRange {

    public int[] searchRange(int[] nums, int target) {

        int s = 0, e = nums.length - 1;
        int startPos = binarySearch(nums, target, s, e, true), endPos = -1;

        if (startPos == -1) {
            return new int[]{startPos, endPos};
        }

        s = startPos + 1;
        e = nums.length - 1;

        endPos = binarySearch(nums, target, s, e, false);

        if (endPos == -1) {
            return new int[]{startPos, startPos};
        }

        return new int[]{startPos, endPos};

    }

    private int binarySearch(int[] nums, int target, int s, int e, boolean startSearch) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            int midVal = nums[mid];

            if (midVal == target) {
                if (startSearch) {
                    if (mid == 0 || nums[mid - 1] < target) {
                        return mid;
                    } else {
                        e = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] > target) {
                        return mid;
                    } else {
                        s = mid + 1;
                    }
                }

            } else if (midVal < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GetRange().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new GetRange().searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(new GetRange().searchRange(new int[]{2, 2}, 2)));


    }
}
