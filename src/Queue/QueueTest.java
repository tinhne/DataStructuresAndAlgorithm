package Queue;

public class QueueTest {
    public static void main(String[] args) {
        int numberOfOperation = 10000000;

        QueueADT circularArrayBasedQueue = new CircularArrayBasedQueue(numberOfOperation);

        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperation; i++) {
            circularArrayBasedQueue.Enqueue(i);
        }
        for (int i = 0; i < numberOfOperation / 2; i++) {
            circularArrayBasedQueue.Dequeue(i);
        }
        for (int i = 0; i < numberOfOperation / 4; i++) {
            circularArrayBasedQueue.Enqueue(i);
        }
        for (int i = 0; i < numberOfOperation / 4; i++) {
            circularArrayBasedQueue.Dequeue(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Circle array based queue took: " + (endTime - startTime));

        QueueADT linkedListBasedQueue = new DoublyLinkedListBasedQueue();

        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperation; i++) {
            linkedListBasedQueue.Enqueue(i);
        }
        for (int i = 0; i < numberOfOperation / 2; i++) {
            linkedListBasedQueue.Dequeue(i);
        }
        for (int i = 0; i < numberOfOperation / 4; i++) {
            linkedListBasedQueue.Enqueue(i);
        }
        for (int i = 0; i < numberOfOperation / 4; i++) {
            linkedListBasedQueue.Dequeue(i);
        }
        endTime = System.nanoTime();
        System.out.println("Linked list based queue took: " + (endTime - startTime));
    }
}
