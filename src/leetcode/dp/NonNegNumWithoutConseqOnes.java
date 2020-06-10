package leetcode.dp;

public class NonNegNumWithoutConseqOnes {

    public int findIntegers(int num) {

        return helper(num, new StringBuilder("0")) + helper(num, new StringBuilder("1"));
    }


    int helper(int num, StringBuilder sb) {

        if (num < 0) {
            return 0;
        }
        System.out.println(sb);


        int count = 0;

        if (sb.charAt(0) == '1') {
            sb.insert(0, '0');
            count += helper(num - Integer.parseInt(sb.toString(), 2), sb);
        } else {
            sb.insert(0 , '0');
            count += helper(num - Integer.parseInt(sb.toString(), 2), sb);
            sb.delete(0, 0);
            sb.insert(0, '1');
            count += 1 + helper(num - Integer.parseInt(sb.toString(), 2), sb);


        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(new NonNegNumWithoutConseqOnes().findIntegers(5));
    }
}
