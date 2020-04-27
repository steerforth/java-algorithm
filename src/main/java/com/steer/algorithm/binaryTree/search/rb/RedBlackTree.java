package com.steer.algorithm.binaryTree.search.rb;

public class RedBlackTree<T extends Comparable<T>> {
    private RBNode<T> root;
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    public class RBNode<T extends Comparable<T>>{
        boolean color;
        T key;
        RBNode parent;
        RBNode left;
        RBNode right;

        public RBNode(boolean color, T key, RBNode parent, RBNode left, RBNode right) {
            this.color = color;
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}
