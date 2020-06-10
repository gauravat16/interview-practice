package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        helper(res, new ArrayList<>(), 1, A, B);

        return res;


    }

    void helper(ArrayList<ArrayList<Integer>> res, List<Integer> combi, int curr, int max, int k){
        if(combi.size() == k){
            res.add(new ArrayList<>(combi));
            return;
        }

        for(int i=curr; i<=max; i++){
            combi.add(i);
            helper(res, combi, curr+1, max, k);
            combi.remove(combi.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }

}
