package src.at.fhooe.swe4;

import java.util.Random;

public class Heap {
    public static void main(String[] args) {
        System.out.println("Hiiii");

        DHeapQueue<Integer> h = new DHeapQueue<>();
        //System.out.println(h);
        System.out.println(h);
        // System.out.println(h.dequeue());
        //h.enqueue(2);
        System.out.println(h);

        Random r = new Random();
        for (int i = 0; i < 9; i++) {
            h.enqueue(r.nextInt(100));
        }
        System.out.println(h);

        while (!h.isEmpty()) {
            System.out.println(h.dequeue());
            // System.out.println(h);
        }
        System.out.println(h);



    }


}
