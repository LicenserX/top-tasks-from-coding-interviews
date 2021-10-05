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
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    private int counter;
    private final int limit;
    private final LinkedList<Integer> integers;

    public Producer(int counter, int limit, LinkedList<Integer> integers) {
        this.counter = counter;
        this.limit = limit;
        this.integers = integers;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (integers) {
                    while (!integers.isEmpty()) {
                        integers.wait();
                    }
                    while (integers.size() < limit) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.println("Элемент добавлен " + integers.add(counter++));
                    }
                    integers.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
