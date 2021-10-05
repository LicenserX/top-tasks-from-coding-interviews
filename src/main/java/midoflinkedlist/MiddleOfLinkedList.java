package midoflinkedlist;

import java.util.LinkedList;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);

        System.out.println(getMiddleElementOfLinkedList(integers));

    }

    public static Integer getMiddleElementOfLinkedList(LinkedList<Integer> linkedList) {
        int mid = linkedList.size() / 2 - 1;

        return linkedList.listIterator(mid).next();
    }
}
