package src.at.fhooe.swe4;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DHeapQueueTest {
    DHeapQueue<Integer> h = new DHeapQueue<>();
    @Test
    void isEmpty() {
        h.enqueue(12);
        assertFalse(h.isEmpty());
    }

    @Test
    void peek() {
        h.enqueue(2);
        assertEquals(5, h.peek());   // Test fails, cause peek()=2
    }

    @Test
    void enqueue() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            h.enqueue(r.nextInt(100));
        }
        assertFalse(h.isEmpty());
    }

    @Test
    void dequeue() {
        while (!h.isEmpty()) {
            h.dequeue();
            // System.out.println(h);
        }
        assertTrue(h.isEmpty());
    }

    @Test
    void test_runtime()  {
        long start = System.nanoTime();
        // do some computations here
        Random r = new Random();
        for (int i = 0; i < 100000; i++) {
            h.enqueue(r.nextInt(1000));
        }
        long time = System.nanoTime() - start;
        System.out.printf("time = %f sec%n", time/1000000000.0);
    }

}