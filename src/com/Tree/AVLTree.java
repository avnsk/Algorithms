package com.Tree;

public class AVLTree {

    public Node leftRotate(Node root) {
        Node newRoot = root.right;
        root.right = root.right.left;
        newRoot.left = root;
        root.height = setHeight(root);
        newRoot.height = setHeight(newRoot);
        return newRoot;

    }

    public Node rightRotate(Node root) {
        Node newRoot = root.left;
        root.left = root.left.right;
        newRoot.right = root;
        root.height = setHeight(root);
        newRoot.height = setHeight(newRoot);
        return newRoot;

    }

    private int setHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max((root.left != null ? root.left.height : 0), (root.right != null ? root.right.height : 0));
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            return root.height;
        }
    }

    private int balance(Node rootLeft, Node rootRight) {
        return height(rootLeft) - height(rootRight);
    }

    public Node insert(Node root, int data) {
        if (root == null) {
            return Node.newNode(data);
        }
        if (root.data <= data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }

        int balance = balance(root.left, root.right);

        if (balance > 1) {
            if (height(root.left.left) >= height(root.left.right)) {
                root = rightRotate(root);
            } else {
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        } else if (balance < -1) {

            if (height(root.right.left) <= height(root.right.right)) {
                root = leftRotate(root);
            } else {
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }

        } else {
            root.height = setHeight(root);
        }

        return root;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String args[]) {
        AVLTree avlTree = new AVLTree();
        Node root = null;
        root = avlTree.insert(root, -10);
        root = avlTree.insert(root, 2);
        root = avlTree.insert(root, 13);
        root = avlTree.insert(root, -13);
        root = avlTree.insert(root, -15);
        root = avlTree.insert(root, 15);
        root = avlTree.insert(root, 17);
        root = avlTree.insert(root, 20);
        avlTree.preOrder(root);


    }
}