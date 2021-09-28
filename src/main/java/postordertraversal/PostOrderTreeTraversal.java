package postordertraversal;

import java.util.*;

import static util.ReflectionUtil.*;

public class PostOrderTreeTraversal {
    public PostOrderTreeTraversal() {
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Set<Integer> integerSet = new TreeSet<>();
        integerSet.add(2);
        integerSet.add(14);
        integerSet.add(13);
        integerSet.add(5);
        integerSet.add(6);
        integerSet.add(18);
        integerSet.add(21);
        integerSet.add(15);


        Object objectM = getNonPublicFieldAsObject(integerSet, "m");
        TreeMap<Integer, Object> treeMap = (TreeMap<Integer, Object>) objectM;

        Object treeRoot = getNonPublicFieldAsObject(treeMap,"root");
        Object treeRoot2 = null;

        lrnRecursiveTraversal(treeRoot);
        System.out.println("");
        lnrTraversal(treeRoot);
    }

    public static void lrnRecursiveTraversal(Object treeRoot) throws NoSuchFieldException, IllegalAccessException {
        if (treeRoot == null) {
            return;
        }

        Object leftNode = getNonPublicFieldAsObject(treeRoot, "left");
        Object rightNode = getNonPublicFieldAsObject(treeRoot, "right");

        lrnRecursiveTraversal(leftNode);
        lrnRecursiveTraversal(rightNode);
        System.out.println(treeRoot);
    }

    public static void lnrTraversal(Object treeRoot) throws NoSuchFieldException, IllegalAccessException {
        Deque<Object> queue = new ArrayDeque<>();

        if (treeRoot == null) {
            return;
        }
        queue.push(treeRoot);

        while (!queue.isEmpty() ) {
            Object currentNode = queue.peek();

            if (isLeaf(currentNode)) {
                System.out.println(queue.pop());
            } else {
                Object rightNode = getNonPublicFieldAsObject(currentNode, "right");
                Object leftNode = getNonPublicFieldAsObject(currentNode, "left");

                if (rightNode != null) {
                    queue.push(rightNode);
                    setValueForNonPublicField(currentNode, "right", null);
                }

                if (leftNode != null) {
                    queue.push(leftNode);
                    setValueForNonPublicField(currentNode, "left", null);
                }
            }
        }
    }



}
