package MyTree;

import java.util.ArrayList;
import java.util.List;

public class BstTree {
    TNode root;
//    Cau 1:
    private TNode insert(int x, TNode t) {
        if (t == null) t = new TNode(x);
        else if (t.data == x) System.out.println(x + " Exist!");
        else if (x < t.data) t.ll = insert(x, t.ll);
        else t.rr = insert(x, t.rr);
        return t;
    }
    public void insert(int x) {
        root = insert(x, root);
    }
    public void createTree(int[] arr) {
        for (int j : arr) {
            insert(j);
        }
    }
    public void F(TNode t) {
        if (t != null) {
            F(t.ll);
            System.out.print(t.data + " ");
            F(t.rr);
        }
    }
    public void findMinMax(TNode t) {
        if (t == null) throw  new RuntimeException("Tree is null");
        TNode curNode = t;
        while (curNode.ll != null) {
            curNode = curNode.ll;
        }
        System.out.println("Min is: " + curNode.data);
        curNode = t;
        while (curNode.rr != null) {
            curNode = curNode.rr;
        }
        System.out.println("Max is: " +curNode.data);
    }
    public void sortArrayUsingBst() {
        List<Integer> sortList = new ArrayList<>();
        sortArrayUsingBst(root, sortList);
        for (int i : sortList) {
            System.out.print(i + " ");
        }
    }
    private void sortArrayUsingBst(TNode t, List<Integer> list) {
        if (t != null) {
            sortArrayUsingBst(t.ll, list);
            list.add(t.data);
            sortArrayUsingBst(t.rr, list);
        }
    }
//    Cau 2:
    public TNode insertBalanceTree(int x, TNode T) {
        if (T == null) {
            return new TNode(x);
        }
        if (height(T.ll) < height(T.rr)) {
            T.ll = insertBalanceTree(x, T.ll);
        }
        else {
            T.rr = insertBalanceTree(x, T.rr);
        }
        return T;
    }
    public int height(TNode t) {
        if (t == null) return 0;
        int leftHeight = height(t.ll);
        int rightHeight = height(t.rr);
        return Math.max(leftHeight, rightHeight) + 1;
    }
//    Cau 3:
    private TNode insertPerfectBalance(int x, TNode t) {
        if (t == null) return new TNode(x);
        if (countNode(t.ll) < countNode(t.rr))
            t.ll = insertPerfectBalance(x, t.ll);
        else
            t.rr = insertPerfectBalance(x, t.rr);
        return t;
    }
    public void insertPerfectBalance(int x) {
        root = insertPerfectBalance(x, root);
    }
    public int countNode(TNode t) {
        if (t == null) return 0;
        return 1 + countNode(t.rr) + countNode(t.ll);
    }
    public static void main(String[] args) {
        System.out.println("Cau 1:");
        BstTree T = new BstTree();
        BstTree K = new BstTree();
        BstTree H = new BstTree();
        int[] x = {2, 3, 5, 10, 12, 1, 4, 7, 10, 22};
        T.createTree(x);
        T.F(T.root);
        System.out.println();
        T.findMinMax(T.root);
        T.sortArrayUsingBst();
        System.out.println("\nCau 2:");
        for (int i : x) {
            K.root = K.insertBalanceTree(i, K.root);
        }
        System.out.println(K.height(K.root));
        K.F(K.root);
        System.out.println("\nCau 3: ");
        for (int i : x) {
            H.insertPerfectBalance(i);
        }
        System.out.println(K.countNode(H.root));
        H.F(H.root);
    }
}
