package leadsquared;

public class Coupons {

    public int coupons(int input1, int input2, int[][] input3, int[][] input4, int input5, int[][] input6) {


        int sum = 0;

        for (int[] tup : input6) {
            int p = tup[0] - 1;
            int s = tup[1] - 1;
            int[] pCoup = input4[p];
            int[] sCoup = input3[s];

            for (int c1 : pCoup) {
                if (c1 == 0) {
                    continue;
                }
                boolean yes = false;
                for (int c2 : sCoup) {
                    if (c2 == 1) {
                        yes = true;
                        break;
                    }
                }

                if (yes) {
                    sum++;
                    break;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
       // System.out.println(new Coupons().coupons(1, 1, new int[][]{{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}}, new int[][]{{1, 0, 0, 1, 0, 0, 0, 0, 0, 0}}, 1, new int[][]{{1, 1}}));
        System.out.println(new Coupons().coupons(1,2, new int[][]{{1, 0, 0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}}, new int[][]{{1, 0, 0, 1, 0, 0, 0, 0, 0, 0}}, 2, new int[][]{{1, 1}, {1, 2}}));

    }
}
