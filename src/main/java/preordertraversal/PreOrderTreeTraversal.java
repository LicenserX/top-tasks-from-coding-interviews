package preordertraversal;

import java.util.*;

import static util.ReflectionUtil.getNonPublicFieldAsObject;

public class PreOrderTreeTraversal {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Set<Integer> integerSet = new TreeSet<>();
        integerSet.add(1);
        integerSet.add(7);
        integerSet.add(2);
        integerSet.add(4);
        integerSet.add(6);
        integerSet.add(10);
        integerSet.add(11);
        integerSet.add(12);


        Object objectM = getNonPublicFieldAsObject(integerSet, "m");
        TreeMap<Integer, Object> treeMap = (TreeMap<Integer, Object>) objectM;

        Object treeRoot = getNonPublicFieldAsObject(treeMap,"root");

        nlrRecursiveTraversal(treeRoot);
        System.out.println("");
        nlrTraversal(treeRoot);

    }

    public static void nlrRecursiveTraversal(Object treeRoot) throws NoSuchFieldException, IllegalAccessException {
//        System.out.println(treeRoot);

        if (treeRoot == null) {
            return;
        }

        System.out.println(treeRoot);

        Object leftNode = getNonPublicFieldAsObject(treeRoot,"left");
        Object rightNode = getNonPublicFieldAsObject(treeRoot,"right");

        nlrRecursiveTraversal(leftNode);
        nlrRecursiveTraversal(rightNode);
    }

    public static void nlrTraversal(Object treeRoot) throws NoSuchFieldException, IllegalAccessException {
        Deque<Object> queue = new ArrayDeque<>();

        queue.push(treeRoot);

        while (!queue.isEmpty()) {
            Object currentNode = queue.pop();

            System.out.println(currentNode);

            Object rightNode = getNonPublicFieldAsObject(currentNode,"right");
            Object leftNode = getNonPublicFieldAsObject(currentNode,"left");

            if (rightNode != null) {
                queue.push(rightNode);
            }

            if (leftNode != null) {
                queue.push(leftNode);
            }
        }
    }

/*static final class Entry<K,V> implements Map.Entry<K,V> {
        K key;
        V value;
        Entry<K,V> left;
        Entry<K,V> right;
        Entry<K,V> parent;
        boolean color = BLACK;*/

}
