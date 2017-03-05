package com.Tree;

public class BinaryTreeToSortedLinkList {

   public Node toSortedLinkList(Node root) {
       if(root == null)
           return null;
       if(root.isLeaf()){
         return root ;
       }

       Node left = toSortedLinkList(root.left);
       Node right = toSortedLinkList(root.right);

       root = merge(left,root);
       return  merge(root,right);

   }

    public Node merge(Node node1 ,Node node2) {
        Node result = null;
        if(node1 == null)
            return node2;
        if(node2 == null)
            return node1;

        if(node1.data <= node2.data) {
            result = node1;
            result.next = merge(node1.next ,node2);

        }else{
            result = node2;
            result.next = merge(node1 ,node2.next);
        }
        return result;
    }

    private void print(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.next;
        }
    }
    public static void main(String args[]) {
        BinaryTreeToSortedLinkList  btd = new BinaryTreeToSortedLinkList ();
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(100, head);
        head = bt.addNode(90, head);
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(250,head);
        head = bt.addNode(5, head);
        head = bt.addNode(7, head);
        head = bt.addNode(-7, head);
        head = btd.toSortedLinkList(head);
        btd.print(head);
    }
}
