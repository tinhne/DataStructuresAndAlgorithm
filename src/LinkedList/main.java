package LinkedList;

public class main {
    public static void main(String[] args) {
        DoublyLinkedListADT doublyLinkedListADT = new DoublyLinkedList();
        doublyLinkedListADT.add("aaaa");
        doublyLinkedListADT.add(("bbb"));
        System.out.println(doublyLinkedListADT.toString());
        doublyLinkedListADT.addFirst("ccc");
        doublyLinkedListADT.addLast("dddd");
        System.out.println(doublyLinkedListADT.toString());
        System.out.println(doublyLinkedListADT.contains("bbb"));
        System.out.println(doublyLinkedListADT.indexOf("dddd"));
        doublyLinkedListADT.removeAt(2);
        System.out.println(doublyLinkedListADT.toString());
    }
}
