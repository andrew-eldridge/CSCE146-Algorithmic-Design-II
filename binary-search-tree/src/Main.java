/*
    CSCE 146 Notes 3/24/20
    Binary Search Tree
    Written by Andrew Eldridge
 */

public class Main {

    public static void main(String[] args) {
        // Create an instance of binary search tree
        BinarySearchTree<Integer> intTree = new BinarySearchTree<Integer>();

        // Add example values
        intTree.add(5);
        intTree.add(7);
        intTree.add(2);
        intTree.add(1);
        intTree.add(6);
        intTree.add(3);

        // Print pre-order traversal
        intTree.printPreOrder();
        System.out.println();

        // Print in order
        intTree.printInOrder();
    }
}
