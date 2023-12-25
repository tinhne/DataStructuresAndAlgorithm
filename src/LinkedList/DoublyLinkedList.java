package LinkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements DoublyLinkedListADT<T> {
    private int size;
    private Node<T> head = null;
    private Node<T> tail = null;

    @Override
    public void clear() {
        Node<T> curNode = head;
        while (curNode != null) {
            Node<T> nextNode = curNode.getNext();
            curNode.setNext(null);
            curNode.setPrev(null);
            curNode.setDate(null);
            curNode = nextNode;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            head.setPrev(new Node<>(element, null, head));
            head = head.getPrev();
        }
        size++;
    }

    @Override
    public void addLast(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            tail.setNext(new Node<>(element, tail, null));
            tail = tail.getNext();
        }
        size++;
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty linked list!");
        return head.getDate();
    }

    @Override
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty linked list!");
        return tail.getDate();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty linked list!");
        T data = head.getDate();
        head =head.getNext();
        size--;
        if (isEmpty()) tail = null;
        head.setPrev(null);
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty linked list!");
        T data = tail.getDate();
        tail = tail.getPrev();
        size--;
        if (isEmpty()) head = null;
        else tail.setNext(null);
        return data;
    }

    @Override
    public T remove(Node<T> node) {
        if (node.getPrev() == null) removeLast();
        if (node.getNext() == null) removeFirst();

        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());

        T data = node.getDate();
        size--;

        node.setNext(null);
        node.setPrev(null);
        node.setDate(null);

        return data;

    }

    @Override
    public T remove(Object object) {
        Node<T> curNode = head;

        while (curNode != null) {
            if (object.equals(curNode.getDate())) {
                return remove(curNode);
            }
            curNode = curNode.getNext();
        }
        return null;
    }

    @Override
    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException();

        int i;
        Node<T> curNode;

        if (index < size / 2) {
            i = 0;
            curNode = head;
            while (i != index) {
                curNode = curNode.getNext();
                i++;
            }
        } else {
            i = size - 1;
            curNode = tail;
            while (i != index) {
                curNode = curNode.getPrev();
                i--;
            }
        }
        return remove(curNode);
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        Node<T> curNode = head;

        while (curNode != null) {
            if (object.equals(curNode.getDate())) {
                return index;
            }
            index++;
            curNode = curNode.getNext();
        }
        return -1;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> curNode = head;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        else {
            StringBuilder sb = new StringBuilder(size);
            sb.append("[ ");

            Node<T> curNode = head;

            while (curNode != null) {
                sb.append(curNode.getDate());
                if (curNode.getNext() != null) sb.append(",");
                curNode = curNode.getNext();
            }

            sb.append(" ]");

            return sb.toString();
        }
    }
}
