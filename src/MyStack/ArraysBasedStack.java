package MyStack;

import java.util.Iterator;

public class ArraysBasedStack {
    private int[] arr;
    private int top;

    public ArraysBasedStack(int size) {
        arr = new int[size];
        top = -1;
    }
    public void push(int item) {
        if (isFull()) throw new RuntimeException("Stack is full!");
        arr[++top] = item;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty!");
        return arr[top--];
    }

    public int top() {
        if (isEmpty()) throw new RuntimeException("Stack is empty!");
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == arr.length - 1;
    }
}
