package interviewbit.greedy;

public class MoveSeats {

    public int seats(String A) {
        char[] arr = A.toCharArray();

        int start = 0, startX = 1, sPrev = -1, end = arr.length - 1, ePrev = -1, endX = 1;
        int hops = 0;
        while (start<end) {
            if (arr[start] == 'x') {
                if (sPrev == -1) {
                    sPrev = start;
                } else {
                    hops += (start - sPrev - 1) * startX;
                    startX++;
                    sPrev = start;
                }
            }

            if (end - start == 1) break;

            if (arr[end] == 'x') {
                if (ePrev == -1) {
                    ePrev = end;
                } else {
                    hops += (ePrev - end - 1) * endX;
                    endX++;
                    ePrev = end;
                }
            }

            start++;
            end--;

        }

        return hops;
    }

    public static void main(String[] args) {
        System.out.println(new MoveSeats().seats(".....x..x..x..x...."));
    }
}
