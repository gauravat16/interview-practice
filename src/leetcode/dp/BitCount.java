package leetcode.dp;

public class BitCount {

    public static int getIntegerBitCount(int num) {
        int count = 0;
        int j = 1;
        for (int i = 0; i < 32; i++) {
            if ((j << i & num) != 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 11, 21, 2345, 3121, 546, 7, 534654537, 3, 1, 13};

        for (int n : nums) {
            System.out.println(Integer.toBinaryString(n));
            System.out.println(BitCount.getIntegerBitCount(n));
        }

    }
}
