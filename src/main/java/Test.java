import consumer.Consumer;
import producer.Producer;

import java.util.LinkedList;
import java.util.Queue;

public class Test {


    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        Thread consumer = new Thread(new Consumer(queue));
        Thread producer = new Thread(new Producer(queue, 10));

        consumer.start();
        producer.start();


    }
}
