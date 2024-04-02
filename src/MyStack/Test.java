package MyStack;

public class Test {
    public static void main(String[] args) {
        LinkedListBaseStack<Integer> myStack = new LinkedListBaseStack<>();
        myStack.push(12);
        myStack.push(13230);
        myStack.push(12314);
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println("Size of stack: " + myStack.size());
        System.out.println("Show element in stack (LIFO): ");
        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
        System.out.println("Stack is empty: " + myStack.isEmpty());
    }

}
