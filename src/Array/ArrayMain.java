package Array;

public class ArrayMain {
    public static void main(String[] args) {
        DynamicArray<String> dynamicArray = new DynamicArray<>();

        dynamicArray.add("1");
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("4");
        dynamicArray.add("5");

        System.out.println(dynamicArray);
    }
}
