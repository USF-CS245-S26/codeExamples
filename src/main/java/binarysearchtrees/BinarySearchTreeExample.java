package binarysearchtrees;

public class BinarySearchTreeExample {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertIterative(6);
        tree.insertIterative(1);
        tree.insertIterative(10);
        tree.insertIterative(8);
        tree.insertIterative(12);
        tree.insertIterative(16);
        tree.printPreorder();
        System.out.println();
        System.out.println(tree.findIterative(12));
        tree.deleteIterative(12);
        tree.printPreorder();
        System.out.println();
        System.out.println(tree.findIterative(12));
    }
}
