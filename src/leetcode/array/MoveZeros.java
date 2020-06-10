package leetcode.array;

import java.util.Arrays;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int pos = -1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0 && pos == -1){
                pos = i;
            }else if(nums[i] != 0 && pos != -1){
                swap(nums, pos, i);
                pos = pos+1;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0, 1, 0, 3, 12};
        new MoveZeros().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
