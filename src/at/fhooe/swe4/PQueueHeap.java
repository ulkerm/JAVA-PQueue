package src.at.fhooe.swe4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PQueueHeap<T extends Comparable<T>> implements PQueue<T> {
    private List<T> values;

    public PQueueHeap() {
        values = new ArrayList<>();
    }
    private boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }


    public T peek() {
        return values.isEmpty() ? null : values.get(0);
    }

    public void enqueue(T value) {
        assert isHeap();
        values.add(value);
        upHeap();
        assert isHeap();
    }

    public T dequeue() {
        assert isHeap();
        if (values.isEmpty())
            throw new NoSuchElementException("cannot dequeue from empty queue");
        T top = values.get(0);
        int last = values.size() - 1;
        values.set(0, values.get(last));
        values.remove(last);
        if (!values.isEmpty())
            downHeap();
        assert isHeap();
        return top;
    }


    private static int parent(int i) {
        return (i - 1) / 2;
    }

    private static int left(int i) {
        return i * 2 + 1;
    }

    private static int right(int i) {
        return i * 2 + 2;
    }


    private void upHeap() {
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
        StringBuilder sb = new StringBuilder();
        sb.append("heap = [");
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(values.get(i));
        }
        sb.append("]");
        return sb.toString();
    }

}
