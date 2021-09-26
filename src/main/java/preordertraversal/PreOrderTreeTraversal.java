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


        Object objectM = getNonPublicFieldAsObject(integerSet, "m");
        TreeMap<Integer, Object> treeMap = (TreeMap<Integer, Object>) objectM;

        Object objectRoot = getNonPublicFieldAsObject(treeMap,"root");

        nlrRecursiveTraversal(objectRoot);
    }

    public static void nlrRecursiveTraversal(Object treeRoot) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(treeRoot);

        if (treeRoot == null) {
            return;
        }
//        System.out.println(treeRoot);
        Object objectLeft = getNonPublicFieldAsObject(treeRoot,"left");
        Object objectRight = getNonPublicFieldAsObject(treeRoot,"right");

        nlrRecursiveTraversal(objectLeft);
        nlrRecursiveTraversal(objectRight);
    }


    private static Object getNonPublicFieldAsObject(Object source, String nameOfFieldToBeExtracted)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = source.getClass().getDeclaredField(nameOfFieldToBeExtracted);
        field.setAccessible(true);
        return field.get(source);
    }


/*static final class Entry<K,V> implements Map.Entry<K,V> {
        K key;
        V value;
        Entry<K,V> left;
        Entry<K,V> right;
        Entry<K,V> parent;
        boolean color = BLACK;*/

}
