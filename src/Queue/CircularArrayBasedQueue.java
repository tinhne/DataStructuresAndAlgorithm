package Queue;

import java.util.Iterator;
import java.util.Queue;

public class CircularArrayBasedQueue<T> implements QueueADT<T> {
    private final T[] array;
    private int front;
    private int end;
    private final int size;

    public CircularArrayBasedQueue(int maxSize) {
        front = end = 1;
        size = maxSize + 1;
        array = (T[]) new Object[size];
    }

    @Override
    public void Enqueue(T element) {
        array[end] = element;
        if (++end == size) end = 0;
        if (end == front) throw new RuntimeException("Queue is full!");
    }

    @Override
    public T Dequeue(T element) {
        if (isEmpty()) throw new RuntimeException("Queue is null!");
        T deQueueItem = array[front];
        if (++front == size) front = 0;
        return deQueueItem;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return array[front];
    }

    @Override
    public int size() {
        if (front > end) return size - front + end;
        return end - front;
    }

    @Override
    public boolean isEmpty() {
        return front == end;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {return false;}

            @Override
            public T next() {return null;}
        };
    }
}
