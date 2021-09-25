package preordertraversal;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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


        Field fieldM = integerSet.getClass().getDeclaredField("m");
        fieldM.setAccessible(true);
        Object objectM = fieldM.get(integerSet);
        TreeMap<Integer, Object> treeMap = (TreeMap<Integer, Object>) objectM;

        Field fieldRoot = treeMap.getClass().getDeclaredField("root");
        fieldRoot.setAccessible(true);
        Object objectRoot = fieldRoot.get(treeMap);

        nlrTraversal(objectRoot);
    }

    public static void nlrTraversal(Object treeRoot) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(treeRoot);

        if (treeRoot == null) {
            return;
        }
//        System.out.println(treeRoot);

        Field fieldLeft = treeRoot.getClass().getDeclaredField("left");
        fieldLeft.setAccessible(true);
        Object objectLeft = fieldLeft.get(treeRoot);

        Field fieldRight = treeRoot.getClass().getDeclaredField("right");
        fieldRight.setAccessible(true);
        Object objectRight = fieldRight.get(treeRoot);

        nlrTraversal(objectLeft);
        nlrTraversal(objectRight);
    }


/*static final class Entry<K,V> implements Map.Entry<K,V> {
        K key;
        V value;
        Entry<K,V> left;
        Entry<K,V> right;
        Entry<K,V> parent;
        boolean color = BLACK;*/

}
