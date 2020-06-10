package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestCommonPrefix {

    public String longestCommonPrefix(List<String> arr) {

        Collections.sort(arr);

        String maxPrefix = "";
        for(int i=0; i<arr.size()-1;i++){
            String a = maxPrefix=="" ? arr.get(i) : maxPrefix;
            String b = arr.get(i+1);

            String prefix = getCommonPrefix(a, b);

            if(prefix.length() == 0){
                return "";
            }

            if(prefix.length() <= maxPrefix.length() || maxPrefix.length()==0){
                maxPrefix = prefix;
            }
        }

        return maxPrefix;
    }

    private String getCommonPrefix(String a, String b){
        int i = 0;
        int j = 0;

        StringBuilder sb = new StringBuilder();

        while(i<a.length() && j< b.length()){
            if(a.charAt(i) == b.charAt(j)){
                sb.append(a.charAt(i));
            }else{
                break;
            }
            i++;
            j++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(Arrays.asList("abcd", "abde", "abcf")));
    }
}
