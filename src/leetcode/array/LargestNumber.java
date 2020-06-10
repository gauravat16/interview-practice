package leetcode.array;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {

        String[] strNums = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, (a, b) -> (b+a).compareTo(a+b));

        String number = String.join("", strNums);
        return number.startsWith("0") ? "0" : number;
    }


    public static void main(String[] args) {
//        System.out.println(new LargestNumber().largestNumber(new int[]{3, 30, 34, 5, 9}));
//        System.out.println(new LargestNumber().largestNumber(new int[]{0, 0}));
        System.out.println(new LargestNumber().largestNumber(new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247}));


        /**
         * 9609 938 824 824769735703560743981399
         * 9609 938 8247 82469735703560743981399
         */
    }
}
