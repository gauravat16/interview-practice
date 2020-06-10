package interviewbit;

import java.util.*;

public class PassportCheck {

    static int[] arrayToLoop(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        int[] result = new int[Math.min(arr1.length, arr2.length)];
        boolean isArr1Bigger = arr1.length > arr2.length;
        int[] arrayToSearch = (isArr1Bigger) ? arr2 : arr1;
        int[] arrayToLoop = (isArr1Bigger) ? arr1 : arr2;


        for (int i : arrayToSearch) {
            set1.add(i);
        }


        int k = 0;
        for (int i : arrayToLoop) {
            if (set1.contains(i)) {
                result[k++] = i;
            }
        }

        return result;
    }

    static int[] findDuplicates(int[] arr1, int[] arr2) {
        List<Integer> resTemp = new ArrayList<>();

        int ptr1 = 0, ptr2 = 0;

        for (int i = 0, j = 0; i < arr1.length && j < arr2.length; ) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                resTemp.add(arr1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[resTemp.size()];

        for (int i = 0; i < resTemp.size(); i++) {
            result[i] = resTemp.get(i);
        }
        return result;

    }


    static int[] findDuplicates3(int[] arr1, int[] arr2) {
        List<Integer> resTemp = new ArrayList<>();

        boolean isArr1Bigger = arr1.length > arr2.length;
        int[] arrayToSearch = (isArr1Bigger) ? arr1 : arr2;
        int[] arrayToLoop = (isArr1Bigger) ? arr2 : arr1;

        for (int i = 0; i < arrayToLoop.length; i++) {
            if (binarySearch(arrayToSearch, arrayToLoop[i])) {
                resTemp.add(arrayToLoop[i]);
            }
        }

        int[] result = new int[resTemp.size()];

        for (int i = 0; i < resTemp.size(); i++) {
            result[i] = resTemp.get(i);
        }
        return result;

    }

    static boolean binarySearch(int[] arr, int target) {
        if (arr == null) {
            return false;
        }

        int start = 0, end = arr.length - 1;


        while (start <= end) {

            int mid = (int)(start + Math.floor((end - start) / 2));

            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }

        return false;

    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayToLoop(new int[]{1, 2, 3, 5, 6, 7}, new int[]{3, 6, 7, 8, 20})));
        System.out.println(Arrays.toString(findDuplicates(new int[]{1, 2, 3, 5, 6, 7}, new int[]{3, 6, 7, 8, 20})));
        System.out.println(Arrays.toString(findDuplicates3(new int[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,1, 2, 3, 5, 6, 7}, new int[]{3, 6, 7, 8, 20})));

    }


}
