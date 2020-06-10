package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

    public ArrayList<ArrayList<Integer>> subsets(List<Integer> A) {
        ArrayList<ArrayList<Integer>> powerset = new ArrayList<>();
        powerset.add(new ArrayList<>());

        helper(A, powerset, new ArrayList<>(), 0);

        return powerset;
    }

    private void helper(List<Integer> a, ArrayList<ArrayList<Integer>> powerset,
                        ArrayList<Integer> set, int start){
        if(start>=a.size()){
            return;
        }

        for(int i=start; i<a.size(); i++){
            set.add(a.get(i));
            powerset.add(new ArrayList<>(set));
            helper(a, powerset, set, i+1);
            set.remove(set.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PowerSet().subsets(Arrays.asList(12, 13)));
    }


}
