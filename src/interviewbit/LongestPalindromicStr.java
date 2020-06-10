package interviewbit;

public class LongestPalindromicStr {

    public String longestPalindrome(String str) {

        int s = 0, max = 0;

        for (int i = 0; i < str.length(); i++) {
            int even = extendOnCenter(str, i, i);
            int odd = extendOnCenter(str, i, i + 1);

            if (max < Math.max(odd, even)) {
                s = (even > odd) ? (i - even / 2) : (i - odd / 2 + 1);
                max = Math.max(odd, even);
            }
        }

        return str.substring(s, s+max);
    }

    private int extendOnCenter(String str, int i, int j) {
        while (i >= 0 && j < str.length()) {
            if (str.charAt(i) != str.charAt(j)) {
                break;
            }
            i--;
            j++;
        }

        return j - i -2 + 1;
    }


    public static void main(String[] args) {
        System.out.println(new LongestPalindromicStr().longestPalindrome("bb"));
    }
}
