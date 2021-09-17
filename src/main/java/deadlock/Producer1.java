package deadlock;

import java.util.ArrayList;
import java.util.List;

public class Producer1 implements Runnable{

    private final List<Integer> integers;
    private final List<String> strings;
    private int n;

    public Producer1(List<Integer> integers, List<String> strings, int n) {
        this.integers = integers;
        this.strings = strings;
        this.n = n;
    }

    @Override
    public void run() {
        int i = 0;
        synchronized (integers){
            while (i < n) {
                integers.add(i++);
            }
        }
        int b = 0;
        synchronized (strings) {
            while (b < n) {
                b++;
                strings.add(Thread.currentThread().getName());
            }
        }
    }
}
