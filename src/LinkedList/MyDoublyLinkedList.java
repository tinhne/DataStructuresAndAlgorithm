package LinkedList;

import java.util.Iterator;

public class MyDoublyLinkedList<T> implements DoublyLinkedListADT<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;
    @Override
    public void clear() {
        Node<T> curNode = head;
        while (curNode != null) {
            Node<T> nextNode = curNode.getNext();
            curNode.setPrev(null);
            curNode.setNext(null);
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
        ++size;
    }

    @Override
    public void addLast(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        } else {
            tail.setNext(new Node<>(element,tail,null));
            tail = tail.getNext();
        }
        ++size;
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Linked list is null!");
        return head.getDate();
    }

    @Override
    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Linked list is null!");
        return tail.getDate();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Linked list is null!");
        T data = head.getDate();
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        return data;
    }

    public T insert(T data, int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException();
        if (index == 0) addFirst(data);
        if (index == size - 1) addLast(data);
        Node<T> curNode;
        int i;
        if (index < size / 2) {
            curNode = head;
            for (i = 0; i < index; i++) {
                curNode = curNode.getNext();
            }
        } else {
            curNode = tail;
            for (i = size - 1; i > index; i--) {
                curNode = curNode.getPrev();
            }
        }
        Node newNode = new Node<>(data, curNode.getPrev(), curNode);
        curNode.getPrev().setNext(newNode);
        curNode.setPrev(newNode);
        ++size;
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Linked list is null");
        T data = tail.getDate();
        if (tail == head) {
            head = tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        --size;
        return data;
    }

    @Override
    public T remove(Node<T> node) {
        if (node.getPrev() == null) removeFirst();
        if (node.getNext() == null) removeLast();
        T data = node.getDate();
        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());
        node.setNext(null);
        node.setPrev(null);
        node.setDate(null);
        --size;
        return data;
    }

    @Override
    public T remove(Object object) {
        Node<T> curNode = head;
        while (curNode != null) {
            if (curNode.getDate().equals(object)) remove(curNode);
            curNode = curNode.getNext();
        }
        return null;
    }

    @Override
    public T removeAt(int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException();
        Node<T> curNode;
        int i;
        if (index < size / 2) {
            curNode = head;
            for (i = 0; i < index; i++) {
                curNode = curNode.getNext();
            }
        } else {
            curNode = tail;
            for (i = size - 1; i > index; i--) {
                curNode = curNode.getPrev();
            }
        }
        return remove(curNode);
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        Node<T> curNode = head;
        while (curNode != null) {
            if (curNode.getDate().equals(object))
                return index;
            curNode = curNode.getNext();
            ++index;
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
    public void printDoublyLinkedList() {
        Node<T> curNode = head;
        for (;null != curNode; curNode = curNode.getNext()) {
            System.out.print(curNode.getDate() + " ");
        }
        /*      Use while to browser
        while (curNode != null) {
            System.out.print(curNode.getDate() + " ");
            curNode = curNode.getNext();
        }
        */
        System.out.println();
    }

    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> doublyLinkedList = new MyDoublyLinkedList<>();
        doublyLinkedList.addFirst(22);
        doublyLinkedList.addFirst(12);
        doublyLinkedList.addFirst(33);
        doublyLinkedList.addFirst(42);
        doublyLinkedList.addFirst(52);
        doublyLinkedList.addFirst(73);
        doublyLinkedList.printDoublyLinkedList();
        System.out.println(doublyLinkedList.peekFirst());
        System.out.println(doublyLinkedList.peekLast());
//        doublyLinkedList.clear();
        doublyLinkedList.insert(3, 3);
        doublyLinkedList.printDoublyLinkedList();
    }
}
