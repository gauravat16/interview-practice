package interviewbit;

import java.util.Arrays;

public class KMPStringMatching {

    public int getIndexOfPatternInText(String pattern, String text) {

        int[] lps = buildLongestProperPrefix(pattern);

        int i = 0, j = 0;

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                return i - j;
            } else if (pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }


        }
        return -1;
    }

    public int[] buildLongestProperPrefix(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int len = 0;

        for (int i = 1; i < lps.length; ) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }

        return lps;

    }

    public static void main(String[] args) {
        System.out.println(new KMPStringMatching().getIndexOfPatternInText("ABABCABAB", "ASDDASDABABCABABJAASDKBSAKDHADSAD"));
    }
}
