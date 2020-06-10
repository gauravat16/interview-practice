package interviewbit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotatedSortedArr {

    public int search(final List<Integer> A, int B) {

        int pivot = -1, low =0, high = A.size() -1;

        while(low<=high){

            int mid = (low+high)/2;

            if(A.get(mid) > A.get(high)){
                low = mid+1;
            }else {
                high = mid -1;
            }
        }

        pivot = low;

        int index1 = Collections.binarySearch(A.subList(0, pivot+1), B);
        int index2 = Collections.binarySearch(A.subList(pivot, A.size()), B);

        if(index1 < 0 && index2 <0){
            return -1;
        }

        return (index2<0)? index1 : index2 + pivot;

    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length < 1)
            return -1;
        int high = nums.length-1,low = 0;
        int mid;
        while(low < high){
            mid = (low+high)/2;
            if(nums[mid] > nums[high])
                low = mid+1;
            else
                high = mid;
        }
        int realmid = low;
        if(nums[realmid] <= target && nums[nums.length-1] >= target){
            return normalBinarySearch(nums,target,realmid,nums.length-1);
        }
        else{
            return normalBinarySearch(nums,target,0,realmid-1);
        }
    }

    private int normalBinarySearch(int[] nums,int target,int start,int end){
        int mid = (start+end)/2;
        if(start > end)
            return -1;
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] < target){
            return normalBinarySearch(nums,target,mid+1,end);

        }
        else{
            return normalBinarySearch(nums,target,start,mid-1);
        }
    }

    public static void main(String[] args) {
       // System.out.println(new RotatedSortedArr().search(Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3), 2));
        System.out.println(new RotatedSortedArr().search(Arrays.asList(9,8,7,6,5,4,3,2,1), 2));
        System.out.println(new RotatedSortedArr().search(new int[]{9,8,7,6,5,4,3,2,1}, 2));

    }
}
