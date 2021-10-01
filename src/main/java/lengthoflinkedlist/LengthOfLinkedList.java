package lengthoflinkedlist;

import java.util.LinkedList;

import static util.ReflectionUtil.getNonPublicFieldAsObject;

public class LengthOfLinkedList {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(3);

        System.out.println(getLengthOfLinkedList(integers));
    }

    public static final int getLengthOfLinkedList(LinkedList<Integer> linkedList) throws NoSuchFieldException, IllegalAccessException {

        if (linkedList == null) {
            return 0;
        }

        Object currentNode = getNonPublicFieldAsObject(linkedList, "first");
        int length = 0;

        while (currentNode != null) {
            length++;
            currentNode = getNonPublicFieldAsObject(currentNode, "next");
        }
        return length;
    }
}


