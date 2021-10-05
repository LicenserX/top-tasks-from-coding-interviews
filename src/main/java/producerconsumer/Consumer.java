package producerconsumer;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private int limit;
    public final LinkedList<Integer> integers;

    public Consumer(int limit, LinkedList<Integer> integers) {
        this.limit = limit;
        this.integers = integers;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (integers) {
                    while (integers.isEmpty()) {
                        integers.wait();
                    }
                    while (integers.size() > 0) {
                        TimeUnit.MILLISECONDS.sleep(100);
                        System.out.println("Элемент получен " + integers.pop());
                    }
                    integers.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
