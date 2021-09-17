package consumer;

import java.util.Queue;

public class Consumer implements Runnable {
    final Queue<String> queue;

    public Consumer(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (true) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.notifyAll();
                System.out.println(queue.poll());
            }
        }
    }
}
