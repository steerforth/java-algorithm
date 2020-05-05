package com.steer.algorithm.binaryTree;

import org.junit.jupiter.api.Test;

/**
 * 根据前序和后序遍历构造二叉树
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 *
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 */
public class LeeCode889 {

    /**
     *                1
     *         2            3
     *     4      5     6      7
     */
    @Test
    public void test(){
        int[] pre = new int[]{1,2,4,5,3,6,7};
        int[] post = new int[]{4,5,2,6,7,3,1};
        Node root = constructFromPrePost(pre, post);
        TreeUtil.traverseInOrder(root);
    }

    int preIndex = 0, posIndex = 0;

    private Node constructFromPrePost(int[] pre, int[] post) {
        Node root = new Node(pre[preIndex++]);
        if (root.getData() != post[posIndex])
            root.setLeft(constructFromPrePost(pre, post));
        if (root.getData() != post[posIndex])
            root.setRight(constructFromPrePost(pre, post));
        posIndex++;
        return root;
    }
}
