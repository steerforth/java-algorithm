package com.steer.algorithm.binaryTree.search;

import com.steer.algorithm.binaryTree.Node;
import com.steer.algorithm.binaryTree.TreeUtil;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    /**
     *                35
     *            /        \
     *          4          50
     *        /   \       /   \
     *       3    15    40     80
     *     /     /  \        /   \
     *    1     8    20    70    90
     *                \
     *                30
     */
    @Test
    public void test(){
        BinarySearchTree tree = new BinarySearchTree(new Node(35));

        tree.addNode(4);
        tree.addNode(15);
        tree.addNode(3);
        tree.addNode(1);
        tree.addNode(20);
        tree.addNode(8);
        tree.addNode(50);
        tree.addNode(40);
        tree.addNode(30);
        tree.addNode(80);
        tree.addNode(70);

        tree.addNode(90);

        tree.deleteNode(50);
        System.out.println("=====中序遍历 递归法=====");
        TreeUtil.traverseInOrder(tree.getRoot());

        System.out.println("");
        System.out.println("=====中序遍历 迭代法=====");
        TreeUtil.traverseInOrderByIteration(tree.getRoot());

        System.out.println("");
        System.out.println("=====前序遍历=====");
        TreeUtil.traversePreOrder(tree.getRoot());

        System.out.println("");
        System.out.println("=====中序遍历 迭代法=====");
        TreeUtil.traversePreOrderByIteration(tree.getRoot());

        System.out.println("");
        System.out.println("=====后序遍历=====");
        TreeUtil.traversePostOrder(tree.getRoot());

        System.out.println("");
        System.out.println("=====后序遍历 迭代法=====");
        TreeUtil.traversePostOrderByIteration(tree.getRoot());

        System.out.println("");
        System.out.println("=====层次遍历=====");
        TreeUtil.traverseLevelOrder(tree.getRoot());

        int height = TreeUtil.getChildDepth(tree.getRoot());
        System.out.println("");
        System.out.println("树高:"+height);
    }
}
