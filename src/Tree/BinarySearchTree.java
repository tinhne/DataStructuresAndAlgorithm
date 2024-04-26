package Tree;

import Stack.LinkedListBasedStack;
import Stack.StackADT;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements TreeADT<T>{
    private int nodeCount = 0;
    private Node root = null;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public boolean contains(T elem) {
        return contains(root, elem);
    }

    @Override
    public boolean add(T elem) {
        if (contains(elem)) return false;
        root = add(root, elem);
        nodeCount++;
        return true;
    }

    @Override
    public boolean remove(T elem) {
        if (!contains(elem)) return false;
        root = remove(root, elem);
        nodeCount--;
        return true;
    }

    @Override
    public Iterator<T> traverse(TreeTraverseType type) {
        switch (type) {
            case IN_ORDER: return inOrderTraverse();
            case PRE_ORDER: return preOrderTraverse();
            case POST_ORDER: return postOrderTraverse();
            case LEVEL_ORDER: return levelOrderTraverse();
            default: return null;
        }
    }

    private Iterator<T> levelOrderTraverse(){
        return null;
    };
    private Iterator<T> postOrderTraverse(){
        return null;
    };
    private Iterator<T> inOrderTraverse(){
        final int expectedCount = nodeCount;
        StackADT<Node> stack = new LinkedListBasedStack();
        stack.push(root);
        return new Iterator<T>() {
            Node trav = root;
            @Override
            public boolean hasNext() {
                if (expectedCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedCount != nodeCount) throw new ConcurrentModificationException();
                while (trav != null && trav.getLeft() != null) {
                    stack.push(trav.getLeft());
                    trav = trav.getLeft();
                }

                Node node = stack.pop();
                if (node.getRight() != null) {
                    stack.push(node.getRight());
                    trav = node.getRight();
                }
                return (T) node.getDate();
            }
        };
    }
    private Iterator<T> preOrderTraverse(){
        final int expectedCount = nodeCount;
        StackADT<Node> stack = new LinkedListBasedStack();
        stack.push(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedCount != nodeCount) throw new ConcurrentModificationException();

                Node<T> node = stack.pop();

                if (node.getRight() != null) stack.push(node.getRight());
                if (node.getLeft() != null) stack.push(node.getLeft());
                return (T) node.getDate();
            }
        };
    }

//    Private
    private int height(Node<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private boolean contains(Node<T> node, T elem) {
        if (node == null) return false;

        int result = elem.compareTo((T) node.getDate());

        if (result < 0) return contains(node.getLeft(), elem);

        else if (result > 0) return contains(node.getRight(), elem);

        else return true;
    }

    private Node<T> add(Node<T> node, T elem) {
        if (node == null) {
            node = new Node(elem, null, null);
        } else {
            if (elem.compareTo((T)node.getDate()) > 0) node.setRight(add(node.getRight(), elem));
            else node.setLeft(add(node.getLeft(), elem));
        }
        return node;
    }

    private Node<T> remove(Node<T> node, T elem) {
        int result = elem.compareTo((T) node.getDate());
        if (result > 0) {
            node.setRight(remove(node.getRight(), elem));
        } else if (result < 0) {
            node.setLeft(remove(node.getLeft(), elem));
        } else {
            T temp = minRight(node);
            node.setDate(temp);
            node.setRight(remove(node.getRight(), elem));
        }
        return node;
    }

    private T minRight(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return (T) node.getDate();
    }

    private T maxLeft(Node<T> node) {
        while (node.getRight()  != null) {
            node = node.getRight();
        }
        return (T) node.getDate();
    }

}
