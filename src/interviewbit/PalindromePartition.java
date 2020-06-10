package interviewbit;

import java.util.ArrayList;

public class PalindromePartition {

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
        helper(a, 0, a.length()-1, new ArrayList<>(), all);
        return all;
    }

    private void helper(String s, int start, int end, ArrayList<String> curr,
                        ArrayList<ArrayList<String>> all){
        if(start > end){
            all.add(new ArrayList<>(curr));
            return;
        }


        for(int i=0; i<end-start+1; i++){

            if(isPalindrome(s, start, start+i)){
                curr.add(s.substring(start, start+i+1));
                helper(s, start+i+1, end, curr, all);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str, int s, int e){
        while(s<e){
            if(str.charAt(s) != str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartition().partition("cccaacbcaabb"));
    }
}
