package Tree;

class Node<T> {
    private T date;
    private Node<T> left, right;

    public Node(T date, Node<T> left, Node<T> right) {
        this.date = date;
        this.left = left;
        this.right = right;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T getDate() {
        return date;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
