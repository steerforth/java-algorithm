package com.steer.algorithm.binaryTree.avl;

import com.steer.algorithm.binaryTree.Node;
import com.steer.algorithm.binaryTree.TreeUtil;
import org.junit.jupiter.api.Test;

public class AVLTreeTest {
    @Test
    public void test(){
        AVLTree avlTree = new AVLTree(new Node(6));
        avlTree.addNode(3);
        avlTree.addNode(7);
        avlTree.addNode(1);
        avlTree.addNode(4);
        avlTree.addNode(2);
        System.out.println("树高:"+ TreeUtil.getChildDepth(avlTree.getRoot()));
    }
}
