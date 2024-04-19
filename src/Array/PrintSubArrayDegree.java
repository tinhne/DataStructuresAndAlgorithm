package Array;

public class PrintSubArrayDegree {
    int []arr;
    public void Enter(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random()*100);
        }
    }
    public void show() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public void printSubArrDesc() {
        int i = 0;
        while (i < arr.length-1) {
            if (arr[i] > arr[i+1]) {
                System.out.print(arr[i] + " ");
                while (i < arr.length-1 && arr[i] > arr[i+1]) {
                    i++;
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            i++;
        }
    }
    public void printSubArrDescV1() {
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i] > arr[i+1]) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.print(arr[i] + "\n");
            }
        }
    }
    public static void main(String[] args) {
        PrintSubArrayDegree p = new PrintSubArrayDegree();
        p.Enter(1000);
        p.show();
        p.printSubArrDescV1();
    }
}
