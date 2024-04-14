package src.at.fhooe.swe4;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

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
        h.enqueue(33);
        h.enqueue(12);
        h.enqueue(23);
        h.enqueue(5);
        assertEquals(33, h.peek());
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
        Random r = new Random();
        for (int i = 0; i < 40; i++) {
            h.enqueue(r.nextInt(100));
        }
        while (!h.isEmpty()) {
            h.dequeue();
        }
        assertTrue(h.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void test_runtime_enqueue()  {
        long start = System.nanoTime();
        Random r = new Random();
        for (int i = 0; i < 100000; i++) {
            h.enqueue(r.nextInt(1000));
        }
        long time = System.nanoTime() - start;
        System.out.printf("time = %f sec%n", time/1000000000.0);
    }

    @org.junit.jupiter.api.Test
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