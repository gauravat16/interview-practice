package leetcode.array;

public class SubArrProdLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int prod = 1, count = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            prod *= nums[i];

            if (prod < k) {
                count += i - j + 1;
            } else {
                while (prod >= k && j <= i) {
                    prod /= nums[j++];
                }
                count += i - j + 1;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(new SubArrProdLessThanK().numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }
}
