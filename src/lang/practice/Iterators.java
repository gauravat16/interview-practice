package lang.practice;

import java.util.*;

public class Iterators {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        Iterator<Integer> iterator = integers.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        System.out.println();
        ListIterator<Integer> listIterator = integers.listIterator();

        while (listIterator.hasNext()) {
            int elem = listIterator.next();

//            if (elem % 2 == 0) {
//                listIterator.remove();
//            }
            listIterator.add(33);
            break;
        }


        System.out.println(integers);
    }
}
