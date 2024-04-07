package MyStack;

public class Test {
    public static void main(String[] args) {
        System.out.println("Ho va ten: Le Van Trung Tinh");
//        Test LinkedList Base Stack
        LinkedListBaseStack<String> myStack = new LinkedListBaseStack<>();
        myStack.push("Hello");
        myStack.push("1");
        myStack.push("aw");
        myStack.push("asadw");
        myStack.push("asdaw");
        myStack.pop();
        myStack.pop();
        System.out.println("Size of stack: " + myStack.size());
        System.out.println("Show element in stack (LIFO): ");
        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
        System.out.println("Stack is empty: " + myStack.isEmpty());

//        Test Array Base Stack
//        ArraysBasedStack myStack = new ArraysBasedStack(10);
//        myStack.push(20);
//        myStack.push(50);
//        myStack.push(13123);
//        myStack.pop();
//        while (!myStack.isEmpty()) {
//            System.out.println(myStack.pop());
//        }
//        System.out.println("Stack is empty: " + myStack.isEmpty());
    }

}
