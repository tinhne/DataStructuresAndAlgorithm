package MyTree;

public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.createTree();
        tree.output();
        System.out.println("\nThe number of node in tree: " + tree.numberOfNode(tree.root));
        System.out.println("The sum of even number in tree: " + tree.sumEvenNumber(tree.root));
        System.out.println("Max is: " + tree.max(tree.root));
        System.out.println("Sum is: " + tree.sum(tree.root));
        System.out.println("The number leaf nodes is: " + tree.countLeafNode(tree.root));
        
    }
}
