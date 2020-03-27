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

    // Print contents of tree in ascending order
    public void printInOrder() {
        printInOrder(root);
    }

    // Internal method to print in order
    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.leftChild); // Print lesser values first
        System.out.println(node.data); // Then print current node
        printInOrder(node.rightChild); // Finally print greater values
    }

    // Search for given value in tree
    public boolean search(T data) {
        return recursiveSearch(root, data);
    }

    // Internal method for recursive search
    private boolean recursiveSearch(Node node, T data) {
        if (node == null) {
            // Reached a leaf
            return false;
        }
        boolean found = false;
        if (data.compareTo(node.data) == 0) {
            // Values are equal
            found = true;
        } else if (data.compareTo(node.data) > 0) {
            // Value is greater than current node
            found = recursiveSearch(node.rightChild, data);
        } else if (data.compareTo(node.data) < 0) {
            // Value is less than current node
            found = recursiveSearch(node.leftChild, data);
        }
        return found;
    }

    // Remove item from tree
    public void remove(T data) {
        root = remove(root, data);
    }

    // Recursively search for item to remove
    private Node remove(Node node, T data) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) < 0) {
            // Value is less than current node
            node.leftChild = remove(node.leftChild, data);
        } else if (data.compareTo(node.data) > 0) {
            // Value is greater than current node
            node.rightChild = remove(node.rightChild, data);
        } else {
            // Values are equal
            if (node.rightChild == null) {
                return node.leftChild;
            }
            if (node.leftChild == null) {
                return node.rightChild;
            }
            Node temp = findMinInTree(node.rightChild);
            node.data = temp.data;
            node.rightChild = remove(node.rightChild, temp.data);
        }
        return node;
    }

    // Recursively search for smallest node in provided tree
    private Node findMinInTree (Node node) {
        if (node == null) {
            return null;
        }
        if (node.leftChild == null) {
            return node;
        } else {
            return findMinInTree(node.leftChild);
        }
    }

}
