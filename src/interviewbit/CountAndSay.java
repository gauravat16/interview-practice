package interviewbit;

import java.util.HashMap;
import java.util.Map;

public class CountAndSay {


    public String countAndSay(int n) {
        String prev = "1";
        while(n>0){
            int  count = 1;
            char p = prev.charAt(0);
            String temp = "";
            for(int i=1; i<prev.length();i++){
                if(p == prev.charAt(i)){
                    count++;
                }else{
                    temp += count+String.valueOf(p);
                    p= prev.charAt(i);
                    count = 1;
                }
            }
            temp += count+String.valueOf(p);
            prev = temp;
            n--;
        }

        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(2));
    }
}
