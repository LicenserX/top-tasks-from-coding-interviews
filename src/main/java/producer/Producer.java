package producer;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {

    final Queue<String> queue;
    final int limit;

    public Producer(Queue<String> queue, int limit) {
        this.queue = queue;
        this.limit = limit;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (true) {
                try {
                    while (queue.size() > limit) {
                        queue.wait();
                    }
                    queue.notifyAll();
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println(queue.add("1"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

