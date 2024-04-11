package Queue;

import LinkedList.DoublyLinkedList;
import LinkedList.DoublyLinkedListADT;

import java.util.Iterator;

public class DoublyLinkedListBasedQueue<T> implements QueueADT<T>{
    private final DoublyLinkedListADT<T> linkedList = new DoublyLinkedList<>();

    public DoublyLinkedListBasedQueue() {
    }
    public DoublyLinkedListBasedQueue(T firstElement) {
        Enqueue(firstElement);
    }

    @Override
    public void Enqueue(T element) {
        linkedList.addLast(element);
    }

    @Override
    public T Dequeue(T element) {
        if (isEmpty()) throw new RuntimeException("LinkedList is null");
        return linkedList.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new RuntimeException("LinkedList is null");
        return linkedList.peekFirst();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
