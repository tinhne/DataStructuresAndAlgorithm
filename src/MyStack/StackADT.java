package MyStack;

public interface StackADT<T> extends Iterable<T> {
    void push(T item);
    T pop();
    T top();
    boolean isEmpty();
    int size();
}
