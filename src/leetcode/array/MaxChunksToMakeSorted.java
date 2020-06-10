package leetcode.array;

public class MaxChunksToMakeSorted {

    public int maxChunksToSorted(int[] arr) {

        int prevMin =arr[0], currMin = arr[0], count = 0;
        boolean isIncreasing = true, isFirst = true;

        for (int i = 1; i < arr.length; i++) {



            if (isIncreasing) {
                if (arr[i - 1] > arr[i]) {
                    isIncreasing = false;
                    if (prevMin < currMin) {
                        count++;
                    }
                    prevMin = currMin;
                    currMin = arr[i];
                }

            } else {
                if (arr[i - 1] < arr[i]) {
                    isIncreasing = true;
                    if (prevMin < currMin) {
                        count++;
                    }
                    prevMin = arr[i - 1];
                    currMin = arr[i];
                } else {
                    currMin = arr[i];
                }
            }

        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(new int[]{1,0,2,3,4}));
    }

}
