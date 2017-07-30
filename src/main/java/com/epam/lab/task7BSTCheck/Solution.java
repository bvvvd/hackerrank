package com.epam.lab.task7BSTCheck;
public class Solution {

    private Node previous;

    public boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(Node node, int min, int max) {
        return node == null || (node.data < max && min < node.data
                && checkBST(node.left, min, node.data)
                && checkBST(node.right, node.data, max));
    }

    private class Node {
        int data;
        Node left;
        Node right;
    }
}