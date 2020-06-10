package leetcode.dp;

import leetcode.array.JumpGame;

public class JumpGame2 {

    private static int i = 0;

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];

        return jump(nums, 0, dp);
    }

    private int jump(int[] nums, int idx, int[] dp) {

        if (idx >= nums.length - 1) {
            return 0;
        }

        if(nums[idx] == 0 ||(idx >0 && nums[idx-1]>nums[idx])){
            return Integer.MAX_VALUE;
        }
        if (dp[idx] != 0) {
            return dp[idx];
        }

        int min = Integer.MAX_VALUE;
        int jumps = Math.min(idx + nums[idx], nums.length);

        for (int i =idx + 1; i <= jumps; i++) {
            int jump = jump(nums, i, dp);
            if(jump == Integer.MAX_VALUE){
                continue;
            }
            min = Math.min(min, 1 + jump);
        }
        dp[idx] = min;
        i++;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame2().jump(new int[]{2,3,0,1,4}));
        System.out.println(i);
    }
}
