package reverselinkedlist;

import java.util.LinkedList;

import static util.ReflectionUtil.getNonPublicFieldAsObject;
import static util.ReflectionUtil.setValueToNonPublicField;

public class ReverseLinkedList {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        reverseLinkedList(integers);

        System.out.println(integers);

    }

    public static final void reverseLinkedList(LinkedList<Integer> linkedList) throws NoSuchFieldException, IllegalAccessException {
        if (linkedList == null) {
            return;
        }

        Object currentNode = getNonPublicFieldAsObject(linkedList, "first");
        Object nextNode = null;
        Object previousNode = null;


        while (currentNode != null) {
            //Подготовка, сохраннение ссылки на следующий объект перед ее переприсовением.
            nextNode = getNonPublicFieldAsObject(currentNode, "next");

            // Непосредственно сам реверс ссылки, а также изменение текущей ноды в цепочке
            // на первую ноду в цепочке (first)
            setValueToNonPublicField(currentNode, "next", previousNode);
            setValueToNonPublicField(linkedList, "first", currentNode);

            //Подготовка, переприсвоение ссылок перед следующей итерацией.
            previousNode = currentNode;
            currentNode = nextNode;
        }
    }
}
