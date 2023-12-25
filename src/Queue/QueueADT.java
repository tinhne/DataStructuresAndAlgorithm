package Queue;

public interface QueueADT<T> extends Iterable<T>{
     void Enqueue(T element);
     T Dequeue(T element);
     T peek();
     int size();
     boolean isEmpty();
}
