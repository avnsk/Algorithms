package com.Tree;

public class BinaryTreeToCircularLinkList {

    public Node convertNode(Node root) {
        if(root == null)
            return null;
        if(root.isLeaf()){
            root.left = root;
            root.right = root;
            return root;
        }
        Node left = convertNode(root.left);
        Node right = convertNode(root.right);
        root.left = root;
        root.right = right;

        left = join(left, root);
        left = join(left, right);
        return left;
    }

    private Node join(Node node1, Node node2) {
        if(node1 == null)
            return node2;
        if(node2 == null)
            return node1;
        Node temp = node2.left;
        node1.left.right = node2;
        node2.left = node1.left;
        node1.left = temp;
        temp.right = node1;

        return node1;
    }
    private void print(Node root){
        Node temp = root;
        do{
            System.out.println(temp.data);
            temp = temp.right;
        }while(temp != root);

        System.out.println();
        do{
            System.out.println(temp.data);
            temp = temp.left;
        }while(temp != root);
    }

    public static void main(String args[]){
        BinaryTreeToCircularLinkList btc = new BinaryTreeToCircularLinkList();
        BinaryTree bt = new BinaryTree();
        Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(3, root);
        root = bt.addNode(-1, root);
        root = bt.addNode(8, root);
        root = bt.addNode(-6, root);
        root = bt.addNode(13, root);
        root = btc.convertNode(root);
        btc.print(root);
    }
}
