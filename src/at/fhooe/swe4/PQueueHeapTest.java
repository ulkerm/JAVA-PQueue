package src.at.fhooe.swe4;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PQueueHeapTest {
    PQueueHeap<Integer> h = new PQueueHeap<>();
    @org.junit.jupiter.api.Test
    void isEmpty() {
        h.enqueue(2);
        assertFalse(h.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void peek() {
        h.enqueue(2);
        //assertEquals(5, h.peek());   // Test fails, cause peek()=2
    }

    @org.junit.jupiter.api.Test
    void enqueue() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            h.enqueue(r.nextInt(100));
        }
        assertFalse(h.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void dequeue() {
        while (!h.isEmpty()) {
            h.dequeue();
            // System.out.println(h);
        }
        assertTrue(h.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void test_runtime()  {
        ArrayList<Long> times = new ArrayList<>();

        long start = System.nanoTime();
        // do some computations here
        Random r = new Random();
        for (int i = 0; i < 100000; i++) {
            h.enqueue(r.nextInt(1000));
            times.add(System.nanoTime() - start);
        }

        for (Long time : times) {
            System.out.println(time);
        }
        //System.out.printf("time = %f sec%n", time/1000000000.0);
    }

}