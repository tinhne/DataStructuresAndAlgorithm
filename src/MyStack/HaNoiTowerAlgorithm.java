package MyStack;

public class HaNoiTowerAlgorithm {
    void HaNoiTowerRecursion(int n, char A, char C, char B) {
        int dem = 0;
        if (n == 1) {
            System.out.println(A + "-->" + C);
        } else {
            HaNoiTowerRecursion(n-1, A, B, C);
            System.out.println(A + "-->" + C);
            HaNoiTowerRecursion(n-1, B, C, A);
        }
    }

    void HaNoiTowerStack(int n, char fromRod, char toRod, char auxRod) {
//        LinkedListBaseStack<Character> fromStack = new LinkedListBaseStack<>();
//        LinkedListBaseStack<Character> toStack = new LinkedListBaseStack<>();
//        LinkedListBaseStack<Character> auxStack = new LinkedListBaseStack<>();
//
//        for (int i = n; i >= 1; i--) {
//            fromStack.push((char) ('0' + i));
//        }
//
//        while (!fromStack.isEmpty() || !auxStack.isEmpty()) {
//
//        }

    }

    public static void main(String[] args) {
        HaNoiTowerAlgorithm a = new HaNoiTowerAlgorithm();
        a.HaNoiTowerRecursion(4, 'A', 'C', 'B');
    }
}
