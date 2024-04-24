package src.at.fhooe.swe4;

import java.util.ArrayList;
import java.util.Random;

public class Heap {
    public static void main(String[] args) {
        //DHeapQueue<Integer> h = new DHeapQueue<>();
        PQueueHeap<Integer> h = new PQueueHeap<>();

        ArrayList<Long> times = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 100000; i++) {
            h.enqueue(r.nextInt(1000));
            //times.add(System.nanoTime() - start);
        }
        for (Long time : times) {
            System.out.println(time);
        }

        long start = System.nanoTime();
        while (!h.isEmpty()) {
            h.dequeue();
            times.add(System.nanoTime() - start);
        }

        for (Long time : times) {
            System.out.println(time);
        }
    }
}
