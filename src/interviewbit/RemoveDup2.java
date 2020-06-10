package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDup2 {

    public int removeDuplicates(List<Integer> a) {

        int i = 1;
        int count = 1;

        for (int j = 1; j < a.size(); j++) {
            if (!a.get(j).equals(a.get(j - 1))) {
                a.set(i++, a.get(j));
                count = 1;
            } else {
                if (count < 2) {
                    a.set(i++, a.get(j));
                }
                count++;
            }

        }

        return i;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDup2().removeDuplicates(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 2, 4, 4)));
    }
}
