package src.at.fhooe.swe4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PQueueHeap<T extends Comparable<T>> implements PQueue<T> {
    private List<T> values; // NOTE: import java.util with Alt+Enter

    public PQueueHeap() {
        values = new ArrayList<>(); // NOTE: <>-operator infers type
    }
    private boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     * Returns the top element without removing it.
     */
    public T peek() {
        return values.isEmpty() ? null : values.get(0);
    }

    /**
     * Adds a new element in correct order
     */

    public void enqueue(T value) {
        assert isHeap(); // create method with Alt+Eneter
        values.add(value); // NOTE: not insert()
        upHeap(); // create method with Alt+Enter
        assert isHeap();
    }

    /**
     * @return the topmost element.
     */
    public T dequeue() {
        assert isHeap();
        if (values.isEmpty())
            throw new NoSuchElementException("cannot dequeue from empty queue");
        T top = values.get(0);
        int last = values.size() - 1;
        values.set(0, values.get(last)); // values[0] = values[size-1];
        values.remove(last);
        if (!values.isEmpty())
            downHeap(); // create method with Alt+Enter
        assert isHeap();
        return top;
    }

    // shift index (no wasted space)
    private static int parent(int i) {
        return (i - 1) / 2;
    } // (i+1)/2-1 -> i/2+1/2-1 -> i/2-1/2 -> (i-1)/2

    private static int left(int i) {
        return i * 2 + 1;
    } // (i+1)*2-1 -> i*2+1*2-1 -> i*2+2-1 -> i*2+1

    private static int right(int i) {
        return i * 2 + 2;
    } // (i+1)*2+1-1 -> i*2+2*2+1-1 -> i*2+2

    /**
     * Moves the bottommost/last element to its correct posistion
     * by repeatedly swapping it with its parent as necessary.
     */
    private void upHeap() { // move statement up (Ctrl+Shift+Up)
        int i = values.size() - 1;
        T x = values.get(i);
        while (i != 0 && less(values.get(parent(i)), x)) {
            values.set(i, values.get(parent(i)));
            i = parent(i);
        }
        values.set(i, x);
    }

    private int largerChild(int i) {
        int indexOfLargerChild = left(i);
        if (right(i) < values.size() && // there is a right child
                less(values.get(indexOfLargerChild), values.get(right(i)))) { // and it is larger
            indexOfLargerChild = right(i);
        }
        return indexOfLargerChild;
    }

    private void downHeap() {
        assert !values.isEmpty();
        int i = 0;
        T x = values.get(0);
        while (left(i) < values.size()) {
            int indexOfLargerChild = largerChild(i);
            if (!less(x, values.get(indexOfLargerChild)))
                break;
            values.set(i, values.get(indexOfLargerChild));
            i = indexOfLargerChild;
        }
        values.set(i, x);
    }

    private boolean isHeap() {
        int i = 1;
        while (i < values.size() && !less(values.get(parent(i)), values.get(i))) {
            i++;
        }
        return i >= values.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // like stringstream
        sb.append("heap = [");
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(values.get(i));
        }
        sb.append("]");
        return sb.toString();
    }

}
