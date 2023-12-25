package Stack;

import LinkedList.DoublyLinkedList;
import LinkedList.DoublyLinkedListADT;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListBasedStack<T> implements StackADT<T> {
    private final DoublyLinkedListADT<T> list = new DoublyLinkedList<>();

    public LinkedListBasedStack() {
    }

    public LinkedListBasedStack(T element) {
        push(element);
    }

    @Override
    public void push(T element) {
        list.addLast(element);
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return list.removeLast();
    }

    @Override
    public T top() {
        return list.peekLast();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
