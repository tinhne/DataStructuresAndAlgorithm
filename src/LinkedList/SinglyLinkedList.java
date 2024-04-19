package LinkedList;

public class SinglyLinkedList<T> {
    class Node<T> {
        T data;
        Node next;
        Node() {
            next = null;
        }
        Node(T data) {
            data = data;
        }
        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    Node head;
    SinglyLinkedList() {
        head = null;
    }
    boolean isEmpty() {
        return head == null;
    }
    void add(T data) {
        head = new Node(data, head);
    }
    void append(T data) {
        if (isEmpty()) {
            head = new Node(data, head);
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new Node(data, null);
        }
    }
    void insert(T data, int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Index out of bounds.");
        if (index == 0) add(data);
        else {
            Node cur = head;
            for (int i = 0; i < index-1; i++) {
                if (cur.next == null) throw new IndexOutOfBoundsException("Index out of bounds.");
                cur = cur.next;
            }
            cur.next = new Node(data, cur.next);
        }
    }
    void removeAt(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Index out of bounds.");
        Node cur = head;
        for (int i = 0; i < index-1; i++) {
            if (cur.next == null) throw new IndexOutOfBoundsException("Index out of bounds.");
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }
    void remove(T data) {
        if (isEmpty()) throw new RuntimeException("LinkedList is empty");
        Node cur = head;
        while (head != null && head.data.equals(data)) {
            head = head.next;
        }
        while (cur.next != null) {
            if (cur.next.data.equals(data)) {
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
    }
    void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
     }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(22000);list.add(2000);list.add(2000);list.add(5000);list.add(2000);list.add(3000);
        list.append(12);
        list.insert(39, 1);
//        list.removeAt(7);
        list.remove(20);
        list.printList();
    }
}
