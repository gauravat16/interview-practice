package leetcode.string;


public class MakeAnagram {

    public int minSteps(String s, String t) {

        int[] count = new int[26];


        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        int changes = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                changes += count[i];
            }
        }

        return changes;
    }

    public static void main(String[] args) {
        System.out.println(new MakeAnagram().minSteps("ftngfmcxlfxitnoanvnnfdswndjhgclcbcyrkcwqwlglqylgrcbr",
                "mnpyqiuogwvgjsrzljxryzsqlxatmpkauuemgkxmgshkfdwnpcet"));
    }
}
