package LinkedList;

class Node<T> {
    private T date;
    private Node<T> prev,next;

    public Node(T date, Node<T> prev, Node<T> next) {
        this.date = date;
        this.prev = prev;
        this.next = next;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getDate() {
        return date;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public Node<T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
