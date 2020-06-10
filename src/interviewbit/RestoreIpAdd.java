package interviewbit;

import java.util.ArrayList;

public class RestoreIpAdd {
    public ArrayList<String> restoreIpAddresses(String A) {
        ArrayList<String> all = new ArrayList<>();
        ipAddRestorer(A, 0, all, new StringBuilder(), 0);
        return all;
    }


    private void ipAddRestorer(String str, int s, ArrayList<String> all, StringBuilder sb, int count) {
        if (s == str.length()) {
            if (count == 4) {
                sb.setLength(sb.length() - 1);
                all.add(sb.toString());
                sb.append(".");
            }

            return;
        }

        String substr = "";
        if (s < str.length()) {
            substr = str.substring(s, s + 1);
            if (isValidIpRange(substr)) {
                sb.append(substr).append(".");
                ipAddRestorer(str, s + 1, all, sb, count + 1);
                sb.setLength(sb.length() - (substr.length() + 1));
            }

        }

        if (s + 1 < str.length()) {
            substr = str.substring(s, s + 2);
            if (isValidIpRange(substr)) {
                sb.append(substr).append(".");
                ipAddRestorer(str, s + 2, all, sb, count + 1);
                sb.setLength(sb.length() - (substr.length() + 1));
            }
        }


        if (s + 2 < str.length()) {
            substr = str.substring(s, s + 3);
            if (isValidIpRange(substr)) {
                sb.append(substr).append(".");
                ipAddRestorer(str, s + 3, all, sb, count + 1);
                sb.setLength(sb.length() - (substr.length() + 1));
            }
        }

    }

    private boolean isValidIpRange(String str) {
        int val = Integer.valueOf(str);
        if ((val > 0 && str.charAt(0) == '0') || (val == 0 && str.length() > 1)) {
            return false;
        }
        return val >= 0 && val <= 255;
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIpAdd().restoreIpAddresses("0100100"));
    }
}
