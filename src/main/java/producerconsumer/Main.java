/*
 * Copyright 2021 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */
package producerconsumer;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();

        Thread producer = new Thread(new Producer(0, 10, integers));
        Thread consumer = new Thread(new Consumer(10, integers));

        producer.start();
        consumer.start();

    }
}
