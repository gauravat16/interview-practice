package interviewbit;

import java.util.*;

public class ThreeZeroSum {

    public ArrayList<ArrayList<Integer>> threeSum(List<Integer> a) {
        Collections.sort(a);

        Set<ArrayList<Integer>> list = new HashSet<>();

        for(int i=0; i<a.size()-1; i++){
            int ptr1 = i+1, ptr2 = a.size()-1;

            while(ptr1<ptr2){
                int sum = a.get(i) + a.get(ptr2) + a.get(ptr1);

                if(sum == 0){
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(a.get(i));l.add(a.get(ptr1));l.add(a.get(ptr2));
                    list.add(l);
                }

                if(sum>0){
                    ptr2--;
                }else{
                    ptr1++;
                }
            }
        }

        return new ArrayList<>(list);
    }

    public static void main(String[] args) {
        System.out.println(new ThreeZeroSum().threeSum(Arrays.asList(1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3)));
    }
}
