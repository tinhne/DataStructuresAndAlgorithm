package Stack;

public class StackTest {
    public static void main(String[] args) {
        int numberOfOperation = 10000000;
        StackADT<Integer> arrayBasedStack = new ArrayBasedStack<Integer>(numberOfOperation);

        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperation; i++) {
            arrayBasedStack.push(i);
        }
        for (int i = 0; i < numberOfOperation; i++) {
            arrayBasedStack.push(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Array based stack took: " + (endTime - startTime));


        StackADT<Integer> linkedListBasedStack = new LinkedListBasedStack<>(numberOfOperation);
        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperation; i++) {
            linkedListBasedStack.push(i);
        }
        for (int i = 0; i < numberOfOperation; i++) {
            linkedListBasedStack.push(i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList based stack took: " + (endTime - startTime));
    }
}
