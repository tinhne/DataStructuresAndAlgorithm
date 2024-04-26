package MyTree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Tree {

    TNode root;
    TNode createNode(int data, TNode ll, TNode rr) {
        return new TNode(data, ll, rr);
    }
    void createTree() {
        TNode p = createNode(3, createNode(4, null, null), null);
        TNode q = createNode(6, createNode(11, null, null), createNode(5, null, null));
        TNode r = createNode(7, q, createNode(2, null, null));
        root = createNode(9, p, r);
    }
    void F(TNode t) {
        if (t != null) {
            System.out.print(t.data + " ");
            F(t.ll);
            F(t.rr);
        }
    }
    void output() {
        System.out.println("Browse NLR: ");
        F(root);
        System.out.println("\nBrowse depth: ");
        browseDepth(root);
        System.out.println("\nBrowse width: ");
        browseWidth(root);
    }
    void browseDepth(TNode t) {
        Stack<TNode> stack = new Stack<>();
        stack.push(t);
        while (!stack.empty()) {
            TNode p = stack.peek();
            stack.pop();
            System.out.print(p.data + " ");
            if (p.rr != null) stack.push(p.rr);
            if (p.ll != null) stack.push(p.ll);
        }
    }
    void browseWidth(TNode t) {
        Queue<TNode> queue = new LinkedList<>();
        queue.add(t);
        while (!queue.isEmpty()) {
            TNode p = queue.poll();
            System.out.print(p.data + " ");
            if (p.ll != null) queue.add(p.ll);
            if (p.rr != null) queue.add(p.rr);
        }
    }
    int numberOfNode(TNode t) {
        Queue<TNode> queue = new LinkedList<>();
        queue.add(t);
        int number = 0;
        while (!queue.isEmpty()) {
            TNode p = queue.poll();
            number++;
            if (p.ll != null) queue.add(p.ll);
            if (p.rr != null) queue.add(p.rr);
        }
        return number;
    }
    int sumEvenNumber(TNode t) {
        Stack<TNode> stack = new Stack<>();
        stack.push(t);
        int sum = 0;
        while (!stack.isEmpty()) {
            TNode p = stack.peek();
            if (p.data % 2 == 0) sum += p.data;
            stack.pop();
            if (p.rr != null) stack.push(p.rr);
            if (p.ll != null) stack.push(p.ll);
        }
        return sum;
    }
    int max(TNode t) {
        Stack<TNode> stack = new Stack<>();
        stack.push(t);
        int max = stack.peek().data;
        while (!stack.isEmpty()) {
            TNode p = stack.peek();
            if (max < p.data) max = p.data;
            stack.pop();
            if (p.rr != null) stack.push(p.rr);
            if (p.ll != null) stack.push(p.ll);
        }
        return max;
    }
    int sum(TNode t) {
        Stack<TNode> stack = new Stack<>();
        stack.push(t);
        int sum = 0;
        while (!stack.isEmpty()) {
            TNode p = stack.peek();
            sum += p.data;
            stack.pop();
            if (p.rr != null) stack.push(p.rr);
            if (p.ll != null) stack.push(p.ll);
        }
        return sum;
    }
    int countLeafNode(TNode t) {
        Stack<TNode> stack = new Stack<>();
        stack.push(t);
        int count = 0;
        while (!stack.isEmpty()) {
            TNode p = stack.peek();
            stack.pop();
            if (p.ll == null && p.rr == null) count++;
            if (p.rr != null) stack.push(p.rr);
            if (p.ll != null) stack.push(p.ll);
        }
        return count;
    }

}
