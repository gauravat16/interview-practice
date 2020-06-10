package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveAllDup {

    public int removeElement(List<Integer> a, int b) {

        int j = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == b) {
                if (j == Integer.MIN_VALUE)
                    j = i;
                continue;
            } else if (j != Integer.MIN_VALUE) {
                a.set(j++, a.get(i));
            }


        }

        return j - 1;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveAllDup().removeElement(Arrays.asList(4, 1, 1, 2, 1, 3), 1));
    }
}
