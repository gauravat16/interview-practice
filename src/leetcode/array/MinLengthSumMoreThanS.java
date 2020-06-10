package leetcode.array;

public class MinLengthSumMoreThanS {

    public int minSubArrayLen(int s, int[] nums) {

        int sum = 0, length = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum >= s) {
                while (sum >= s) {
                    sum -= nums[j++];
                }
                length = Math.min(length, i - j + 2);
            }

        }

        return length == Integer.MAX_VALUE ? 0 : length;

    }

    public static void main(String[] args) {
        System.out.println(new MinLengthSumMoreThanS().minSubArrayLen(15, new int[]{1, 2, 3, 4, 5}));
    }
}
