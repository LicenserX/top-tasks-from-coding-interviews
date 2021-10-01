package loopoflinkedlist;

import java.util.LinkedList;

import static util.ReflectionUtil.getNonPublicFieldAsObject;
import static util.ReflectionUtil.setValueToNonPublicField;

public class LoopOfLinkedList {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        createCorruptedLinkedList(integers);

        System.out.println(isLinkedListHasALoop(integers));
    }

    public static final boolean isLinkedListHasALoop(LinkedList<Integer> linkedList) throws NoSuchFieldException, IllegalAccessException {
        int size = linkedList.size();
        int currentSize = 0;

        Object currentNode = getNonPublicFieldAsObject(linkedList, "first");

        while (currentNode != null) {
            if (currentSize > size) {
                break;
            }
            currentSize++;
            currentNode = getNonPublicFieldAsObject(currentNode, "next");
        }

        return size != currentSize;
    }

    public static final void createCorruptedLinkedList(LinkedList<Integer> linkedList) throws NoSuchFieldException, IllegalAccessException {
        Object currentNode = getNonPublicFieldAsObject(linkedList, "first");
        Object nextNode = null;

        if (currentNode !=null) {
            nextNode = getNonPublicFieldAsObject(currentNode, "next");
        }

        if (nextNode != null) {
            setValueToNonPublicField(nextNode, "next", currentNode);
        }
    }
}
