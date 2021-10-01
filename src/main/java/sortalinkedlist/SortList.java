package sortalinkedlist;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SortList {
    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();
        integers.add(3);
        integers.add(11);
        integers.add(6);
        integers.add(5);
        integers.add(5);
        integers.add(2);
        integers.add(10);
        integers.add(0);
        integers.add(7);

        List<Integer> sortedList = integers.stream()
                .sorted(Comparator.comparing(Object::hashCode)) //чисто по приколу, т.к. hashcode = value;
                .collect(Collectors.toList());

        System.out.println(sortedList);
    }
}
