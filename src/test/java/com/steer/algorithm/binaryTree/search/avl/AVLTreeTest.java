package com.steer.algorithm.binaryTree.search.avl;

import com.steer.algorithm.binaryTree.Node;
import com.steer.algorithm.binaryTree.TreeUtil;
import org.junit.jupiter.api.Test;

public class AVLTreeTest {
    /**
     *             6           ->  *             3
     *        3        7       ->  *      1            6
     *    1      4             ->  *         2      4     7
     *      2                  ->  *
     */
    @Test
    public void testLL(){
        AVLTree avlTree = new AVLTree(new Node(6));
        avlTree.addNode(3);
        avlTree.addNode(7);
        avlTree.addNode(1);
        avlTree.addNode(4);
        Node newRoot = avlTree.addNode(2);
        avlTree.setRoot(newRoot);
        System.out.println("树高:"+ TreeUtil.getChildDepth(avlTree.getRoot()));
    }

    @Test
    public void testRR(){
        AVLTree avlTree = new AVLTree(new Node(2));
        avlTree.addNode(1);
        avlTree.addNode(4);
        avlTree.addNode(3);
        avlTree.addNode(6);
        Node newRoot = avlTree.addNode(5);
        avlTree.setRoot(newRoot);
//        AVLTree avlTree = new AVLTree(new Node(26));
//        avlTree.addNode(23);
//        avlTree.addNode(37);
//        avlTree.addNode(11);
//        avlTree.addNode(24);
//        avlTree.addNode(27);
//        avlTree.addNode(40);
//        avlTree.addNode(12);
//        Node newRoot = avlTree.addNode(13);
//        avlTree.setRoot(newRoot);
        System.out.println("树高:"+ TreeUtil.getChildDepth(avlTree.getRoot()));
    }

    @Test
    public void testLR(){
        AVLTree avlTree = new AVLTree(new Node(6));
        avlTree.addNode(2);
        avlTree.addNode(7);
        avlTree.addNode(1);
        avlTree.addNode(4);
        Node newRoot = avlTree.addNode(3);
        avlTree.setRoot(newRoot);
        System.out.println("树高:"+ TreeUtil.getChildDepth(avlTree.getRoot()));
    }

    @Test
    public void testRL(){
        AVLTree avlTree = new AVLTree(new Node(2));
        avlTree.addNode(1);
        avlTree.addNode(5);
        avlTree.addNode(3);
        avlTree.addNode(6);
        Node newRoot = avlTree.addNode(4);
        avlTree.setRoot(newRoot);
        System.out.println("树高:"+ TreeUtil.getChildDepth(avlTree.getRoot()));
    }
}
