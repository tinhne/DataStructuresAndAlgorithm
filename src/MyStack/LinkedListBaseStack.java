package MyStack;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListBaseStack<T> implements StackADT<T> {
    class Node {
        private T data;
        private Node next;

        public Node() {}
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    Node top;
    public LinkedListBaseStack() {
        top = null;
    }
    @Override
    public void push(T data) {
        top = new Node(data, top);
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty!");
        T topData = top.data;
        top = top.next;
        return topData;
    }

    @Override
    public T top() {
        if (isEmpty()) throw new RuntimeException("Stack is empty!");
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator(this);
    }
    public class StackIterator implements Iterator<T> {
        private Node current;
        public StackIterator(LinkedListBaseStack<T> stack) {
            this.current = stack.top;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in Stack!");
            }
            T data =current.data;
            current = current.next;
            return data;
        }
    }
}
