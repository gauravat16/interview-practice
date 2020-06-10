package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal2 {

    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> level = new ArrayList<>();
        level.add(1);


        while(level.size() != a+1){
            int size = level.size();
            ArrayList<Integer> clone = (ArrayList<Integer>)level.clone();

            for(int i=0; i< size && level.size() != a+1; i++){
                int last = clone.get(i);
                int next = clone.size()<=i+1 ? 0 : clone.get(i+1);
                if(next != 0){
                    level.set(i+1,last+next);
                }else{
                    level.add(last);
                }

            }
        }

        return level;
    }

    public static void main(String[] args) {
        System.out.println(new Pascal2().getRow(2));
        List<Integer>  l = Arrays.asList(1, 1, 4,4,6,6,8);
        int num = 0;
        for(int i=0; i< l.size(); i++){
            num = l.get(i) ^ num;
        }

        System.out.println(num);
    }
}
