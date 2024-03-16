package MyStack;

import Stack.LinkedListBasedStack;

import java.util.Iterator;

public class LinkedListBaseStack<T> implements StackADT<T> {
    class Node<T> {
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
    Node<T> top;
    public LinkedListBaseStack() {
        top = null;
    }
    @Override
    public void push(T item) {
        Node<T> q = new Node<>(item, top);
        top = q;
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T top() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
