/*
    CSCE 146 Notes 3/24/20
    Binary Search Tree
    Written by Andrew Eldridge
 */

public class BinarySearchTree<T extends Comparable<T>> {

    // Internal Node class
    private class Node {
        private T data;
        private Node leftChild;
        private Node rightChild;
        public Node(T data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }

    private Node root;
    public BinarySearchTree() {
        root = null;
    }

    // Add element to tree
    public void add(T data) {
        if (root == null) {
            root = new Node(data);
        } else {
            add(root, data);
        }
    }

    // Internal method for adding an element
    private Node add(Node node, T data) {
        if (node == null) {
            // Leaf found
            node = new Node(data);
        } else if (data.compareTo(node.data) < 0) {
            // Go left
            node.leftChild = add(node.leftChild, data);
        } else if (data.compareTo(node.data) > 0) {
            // Go right
            node.rightChild = add(node.rightChild, data);
        }
        return node;
    }

    // Print contents of tree
    public void printPreOrder() {
        printPreOrder(root);
    }

    // Internal method to traverse and print contents of tree
    private void printPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data); // Process current node
        printPreOrder(node.leftChild); // Print recursively left
        printPreOrder(node.rightChild); // Print recursively right
    }

}
