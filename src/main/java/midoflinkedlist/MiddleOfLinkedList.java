/*
 * Copyright 2021 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */
package midoflinkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);

        System.out.println(getMiddleElementOfLinkedList(integers));

    }

    public static Integer getMiddleElementOfLinkedList(LinkedList<Integer> linkedList) {
        ListIterator<Integer> iterator = linkedList.listIterator();
        int mid = linkedList.size() / 2;

        while (iterator.hasNext() && mid != 0) {
            iterator.next();
            mid--;
        }
        return iterator.next();
    }
}
