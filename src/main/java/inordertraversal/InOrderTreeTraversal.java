package inordertraversal;

import java.util.*;

import static util.ReflectionUtil.getNonPublicFieldAsObject;

public class InOrderTreeTraversal {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Set<Integer> integerSet = new TreeSet<>();
        integerSet.add(1);
        integerSet.add(12);
        integerSet.add(24);
        integerSet.add(64);
        integerSet.add(45);
        integerSet.add(52);
        integerSet.add(9);
        integerSet.add(6);

        Object objectM = getNonPublicFieldAsObject(integerSet, "m");
        TreeMap<Integer, Object> treeMap = (TreeMap<Integer, Object>) objectM;

        Object treeRoot = getNonPublicFieldAsObject(treeMap,"root");

        lnrRecursiveTraversal(treeRoot);
        System.out.println("");
        lnrTraversal(treeRoot);
        System.out.println("");
    }

    public static void lnrRecursiveTraversal(Object treeRoot) throws NoSuchFieldException, IllegalAccessException {
        if (treeRoot == null) {
            return;
        }

        Object leftNode = getNonPublicFieldAsObject(treeRoot, "left");
        Object rightNode = getNonPublicFieldAsObject(treeRoot, "right");

        lnrRecursiveTraversal(leftNode);
        System.out.println(treeRoot);
        lnrRecursiveTraversal(rightNode);
    }

    public static void lnrTraversal(Object treeRoot) throws NoSuchFieldException, IllegalAccessException {
        Deque<Object> queue = new ArrayDeque<>();
        Object currentNode = treeRoot;

        while (!queue.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                queue.push(currentNode);
                currentNode = getNonPublicFieldAsObject(currentNode, "left");
            } else {
                currentNode = queue.pop();
                System.out.println(currentNode);
                currentNode = getNonPublicFieldAsObject(currentNode, "right");
            }
        }
    }
}
