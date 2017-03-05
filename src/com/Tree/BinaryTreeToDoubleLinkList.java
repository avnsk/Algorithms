package com.Tree;

public class BinaryTreeToDoubleLinkList {
    static Node prev = null;
    Node head;
    public void binaryTree2DoublyLinkedList(Node root) {
        if(root == null)
            return;

        binaryTree2DoublyLinkedList(root.left);
        if(prev == null) {
            prev = root;
            head = root;

        } else {
            root.left = prev;
            prev.right = root;
            prev = root;

        }
        binaryTree2DoublyLinkedList(root.right);
    }
    void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }



    public static void main(String args[]) {
        BinaryTreeToDoubleLinkList btd = new BinaryTreeToDoubleLinkList();
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(100, head);
        head = bt.addNode(90, head);
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(25, head);
        head = bt.addNode(5, head);
        head = bt.addNode(7, head);
        head = bt.addNode(-7, head);
        btd.binaryTree2DoublyLinkedList(head);
        btd.printList(btd.head);
    }
}

