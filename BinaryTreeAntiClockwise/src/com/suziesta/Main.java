package com.suziesta;

public class Main {
    static class Node
    {
        Node left;
        Node right;
        int data;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        root.left.left.left = new Node(10);
        root.left.left.right = new Node(11);
        root.right.right.left = new Node(8);

        antiClockWiseSpiral(root);
    }

    static void LeftToRight(Node node, int level){
        if(node==null){
            return;
        }
        if(level == 1){
            System.out.print(node.data+" ");
        }
        else if(level > 1) {
            LeftToRight(node.left, level - 1);
            LeftToRight(node.right, level - 1);
        }
    }

    static void rightToLeft(Node node, int level){
        if(node == null)
            return;
        if(level == 1){
            System.out.print(node.data+" ");
        }
        else if(level > 1) {
            rightToLeft(node.right, level - 1);
            rightToLeft(node.left, level - 1);

        }
    }

    private static void antiClockWiseSpiral(Node root) {
        boolean fromleft = false;
        int i=1;
        int j = height(root);

        while(i <= j){
            if(fromleft){
                LeftToRight(root, j);
                j--;
                fromleft = !fromleft;
            }else{
                rightToLeft(root,i);
                i++;
                fromleft = !fromleft;
            }
        }
    }

    private static int height(Node root) {
        if(root==null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left,right)+1;
    }


}
