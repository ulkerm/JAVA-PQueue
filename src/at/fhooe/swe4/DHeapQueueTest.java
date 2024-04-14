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
        h.enqueue(33);
        h.enqueue(12);
        h.enqueue(23);
        h.enqueue(5);
        h.enqueue(53);
        h.enqueue(5);
        h.enqueue(63);
        h.enqueue(5);
        assertEquals(63, h.peek());
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
        Random r = new Random();
        for (int i = 0; i < 22; i++) {
            h.enqueue(r.nextInt(100));
        }
        while (!h.isEmpty()) {
            h.dequeue();
        }
        assertTrue(h.isEmpty());
    }

    @Test
    void test_runtime_enqueue()  {
        long start = System.nanoTime();
        Random r = new Random();
        for (int i = 0; i < 100000; i++) {
            h.enqueue(r.nextInt(1000));
        }
        long time = System.nanoTime() - start;
        System.out.printf("time = %f sec%n", time/1000000000.0);
    }

    @Test
    void test_runtime_dequeue()  {
        Random r = new Random();
        for (int i = 0; i < 100000; i++) {
            h.enqueue(r.nextInt(1000));
        }
        long start = System.nanoTime();
        while (!h.isEmpty()) {
            h.dequeue();
        }
        long time = System.nanoTime() - start;
        System.out.printf("time = %f sec%n", time/1000000000.0);
    }
}