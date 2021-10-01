package thirdelementfromthetaillinkedlist;

import java.util.LinkedList;

public class ThirdElementFromTheTailLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        System.out.println(getElementFromLinkedListByIndex(integers, 4));
    }


    public static final Object getElementFromLinkedListByIndex(LinkedList<Integer> integers, int index) {
        return integers.listIterator(index).next();
    }
}
