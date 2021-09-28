package printallleaves;

import java.util.*;

import static util.ReflectionUtil.getNonPublicFieldAsObject;
import static util.ReflectionUtil.isLeaf;

public class PrintAllLeaves {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Set<Integer> integerSet = new TreeSet<>();
        integerSet.add(4);
        integerSet.add(3);
        integerSet.add(5);
        integerSet.add(6);
        integerSet.add(7);


        Object objectM = getNonPublicFieldAsObject(integerSet, "m");
        TreeMap<Integer, Object> treeMap = (TreeMap<Integer, Object>) objectM;

        Object treeRoot = getNonPublicFieldAsObject(treeMap, "root");

        printAllLeaves(treeRoot);
        System.out.println("");
        printAllLeavesRecursively(treeRoot);
    }

    public static void printAllLeaves(Object treeRoot) throws NoSuchFieldException, IllegalAccessException {
        Deque<Object> queue = new ArrayDeque<>();

        if (treeRoot == null) {
            return;
        }

        queue.push(treeRoot);

        while (!queue.isEmpty()) {
            Object currentNode = queue.pop();

            if (isLeaf(currentNode)) {
                System.out.println(currentNode);
            } else {
                Object leftNode = getNonPublicFieldAsObject(currentNode, "left");
                Object rightNode = getNonPublicFieldAsObject(currentNode, "right");

                if (rightNode != null) {
                    queue.push(rightNode);
                }

                if (leftNode != null) {
                    queue.push(leftNode);
                }
            }
        }
    }

    public static void printAllLeavesRecursively(Object treeRoot) throws NoSuchFieldException, IllegalAccessException {

        if (treeRoot == null) {
            return;
        }

        if (isLeaf(treeRoot)) {
            System.out.println(treeRoot);
        }
        Object leftNode = getNonPublicFieldAsObject(treeRoot, "left");
        Object rightNode = getNonPublicFieldAsObject(treeRoot, "right");

        printAllLeavesRecursively(leftNode);
        printAllLeavesRecursively(rightNode);

    }

}
