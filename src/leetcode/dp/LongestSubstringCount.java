package leetcode.dp;

public class LongestSubstringCount {

//    public int helper(String s, int l, int r, int k) {
//        if (l>=r) return 0;
//
//        // build freq map
//        int[] freq = new int[26];
//        for (int i=l; i<r; i++) freq[s.charAt(i)-'a']++;
//
//        // check if valid
//        boolean valid = true;
//        for (int i=0; i<26 && valid; i++) if (freq[i] > 0 && freq[i] < k) valid = false;
//        if (valid) return r-l;
//
//        // if not for each invalid character start a new split search
//        int best = 0, start=l;
//        for (int i=l; i<r; i++) {
//            if (freq[s.charAt(i) -'a'] < k) {
//                best = Math.max(best, helper(s, start, i, k));
//                start = i+1;
//            }
//        }
//        best = Math.max(best, helper(s, start, r, k));
//        return best;
//    }

    public int longestSubstring(String s, int val) {

        if (s.length() == 0) {
            return 0;
        }

        if (s.length() == 1 && val == 1) {
            return 1;
        }


        return helper(s, 0, s.length() - 1, val);
    }

    public int helper(String str, int s, int e, int k) {
        if (s > e) {
            return 0;
        }

        int[] countArr = new int[26];

        for (int i = s; i <= e; i++) {
            countArr[str.charAt(i) - 'a'] ++;
        }

        boolean valid = true;
        for (int v : countArr) {
            if (v < k && v > 0) {
                valid = false;
                break;
            }
        }

        if (valid) {
            return e - s + 1;
        }

        int max = 0, start = s;
        for (int i = s; i <= e; i++) {
            if (countArr[str.charAt(i) - 'a'] < k) {
                max = Math.max(helper(str, start, i - 1, k), max);
                start = i + 1;
            }
        }
        max = Math.max(helper(str, start, e, k), max);

        return max;

    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringCount().longestSubstring("zzzzzzzzzzaaaaaaaaabbbbbbbbhbhbhbhbhbhbhicbcbcibcbccccccccccbbbbbbbbaaaaaaaaafffaahhhhhiaahiiiiiiiiifeeeeeeeeee", 10));
    }
}
