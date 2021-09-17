package deadlock;

import java.util.ArrayList;
import java.util.List;

public class Deadlock {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        Thread thread1 = new Thread(new Producer1(integers, strings, 10000000));
        Thread thread2 = new Thread(new Producer2(integers, strings, 10000000));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(integers.size());
        System.out.println(strings.size());

        System.out.println(integers);
        System.out.println(strings);
    }
}
