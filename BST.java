// Cristian Rios
// Chpt7 PA

// Definition of a node in the Binary Search Tree (BST)
class BSTNode {
    int key;
    BSTNode left, right;

    // Constructor to initialize the node with a key
    public BSTNode(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}

// Binary Search Tree implementation
class BST {
    private BSTNode root;

    // Constructor to initialize an empty BST
    public BST() {
        root = null;
    }

    // Getter to access the root of the BST
    public BSTNode getRoot() {
        return root;
    }

    // Recursive search for a key starting from a given node
    public BSTNode searchRecursive(BSTNode node, int key) {
        if (node == null || node.key == key) {
            return node;
        }
        if (key < node.key) {
            return searchRecursive(node.left, key);
        } else {
            return searchRecursive(node.right, key);
        }
    }

    // Iterative search for a key in the BST
    public BSTNode search(int key) {
        BSTNode current = root;
        while (current != null && current.key != key) {
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }

    // Checks whether a key exists in the BST
    public boolean contains(int key) {
        return search(key) != null;
    }

    // Inserts a key into the BST if it does not already exist
    public boolean insertKey(int key) {
        if (contains(key)) {
            return false; // Duplicate keys are not allowed
        }
        BSTNode newNode = new BSTNode(key);
        insertNode(newNode);
        return true;
    }

    // Non-recursive insertion of a node into the BST
    private void insertNode(BSTNode node) {
        if (root == null) {
            root = node;
            return;
        }
        BSTNode current = root;
        BSTNode parent = null;

        // Find the correct parent node
        while (current != null) {
            parent = current;
            if (node.key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // Insert as left or right child
        if (node.key < parent.key) {
            parent.left = node;
        } else {
            parent.right = node;
        }
    }

    // Recursive insertion of a node into the BST
    private void insertRecursive(BSTNode parent, BSTNode nodeToInsert) {
        if (nodeToInsert.key < parent.key) {
            if (parent.left == null) {
                parent.left = nodeToInsert;
            } else {
                insertRecursive(parent.left, nodeToInsert);
            }
        } else {
            if (parent.right == null) {
                parent.right = nodeToInsert;
            } else {
                insertRecursive(parent.right, nodeToInsert);
            }
        }
    }

    // Prints the BST in reverse (right-root-left) order
    public void printInReverseOrder(BSTNode node) {
        if (node == null) return;
        printInReverseOrder(node.right);
        System.out.print(node.key + " ");
        printInReverseOrder(node.left);
    }

    // Main method for demonstration and testing
    public static void main(String[] args) {
        BST tree = new BST();

        // Insert a predefined list of keys into the BST
        int[] keys = {35, 41, 13, 57, 3, 83, 88, 51, 38, 20, 11, 22, 27, 21, 48, 8};
        for (int key : keys) {
            tree.insertKey(key);
        }

        // Print the BST in reverse order
        System.out.println("BST in reverse order:");
        tree.printInReverseOrder(tree.getRoot());

        // Print the BST in a 2D formatted layout
        System.out.println("\n\nBST 2D view:");
        BSTPrint.print2D(tree.getRoot());

        // Search for an existing key
        int existingKey = 27;
        if (tree.search(existingKey) != null) {
            System.out.println("\nKey " + existingKey + " found in BST.");
        } else {
            System.out.println("\nKey " + existingKey + " not found in BST.");
        }

        // Search for a non-existing key
        int missingKey = 89;
        if (tree.search(missingKey) != null) {
            System.out.println("Key " + missingKey + " found in BST.");
        } else {
            System.out.println("Key " + missingKey + " not found in BST.");
        }
    }
}