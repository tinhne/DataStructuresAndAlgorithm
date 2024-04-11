package Queue;

import java.util.Iterator;

public class LinkedListBaseQueue<T> implements QueueADT<T> {
    class Node {
        private T data;
        private Node next;
        Node() {
            next = null;
        }
        Node (T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    Node rear, front;
    LinkedListBaseQueue() {
        rear = front = null;
    }

    @Override
    public void Enqueue(T element) {
        Node newNode = new Node(element, null);
        if (isEmpty()) {
            front = rear = new Node(element, null);
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    @Override
    public T Dequeue(T element) {
        if (isEmpty()) throw new RuntimeException("Queue is null!");
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    @Override
    public T peek() {
        return this.front.data;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
