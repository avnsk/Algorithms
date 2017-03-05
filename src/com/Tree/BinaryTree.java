package com.Tree;
class Node{
    Node left;
    Node right;
    Node next;
    int data;


    public static Node newNode(int data){
        Node n = new Node();
        n.left = null;
        n.right = null;
        n.data = data;
        return n;
    }

    public boolean isLeaf() {
        if (this.left == null && this.right == null) {
            return true;
        }
        return false;
    }

}
public class BinaryTree {

    public Node addNode(int data ,Node head) {
        Node tempHead = head;
        Node n = Node.newNode(data);
        if(head == null) {
            head = n;
            return  head;
        }

        Node prev = null;

        while(head != null) {
            prev = head;
            if(data > head.data) {
                head = head.right;
            } else {
                head = head.left;
            }
        }

        if(data> prev.data) {
            prev.right = n;
        } else {
            prev.left = n;
        }

        return tempHead;
    }
}
