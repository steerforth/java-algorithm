package com.steer.algorithm.binaryTree;

import com.steer.algorithm.binaryTree.Node;
import com.steer.algorithm.binaryTree.TreeUtil;
import org.junit.jupiter.api.Test;

/**
 * 已知前序遍历和中序遍历，求后续遍历
 */
public class TestA {
    /**
     *
     */
    @Test
    public void test(){
        int[] preOrder = {1,2,4,8,9,5,10,3,6,7};
        int[] inOrder = {8,4,9,2,10,5,1,6,3,7};
        Node node = initTree(preOrder,inOrder);
        TreeUtil.traversePostOrder(node);
    }

    /**
     * 重构树
     * 前序遍历结论:第一个为根节点
     * 中序遍历结论:根节点遍历结果的左侧为该节点的左子树，右侧为该节点的右子树
     * @param preOrder
     * @param inOrder
     */
    private Node initTree(int[] preOrder, int[] inOrder) {
        return initTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
    }

    private Node initTree(int[] preOrder, int preS, int preE, int[] inOrder, int inS, int inE) {
        if (preS > preE || inS > inE){
            return null;
        }
        int rootVal = preOrder[preS];
        Node root = new Node(rootVal);

        //获取中序遍历root下标
        int rootIndex = findRootIndex(inOrder,inS,inE,rootVal);
        Node left = initTree(preOrder,preS+1,preS+(rootIndex-inS),inOrder,inS,rootIndex-1);
        Node right = initTree(preOrder,preS+(rootIndex-inS)+1,preE,inOrder,rootIndex+1,inE);

        root.setLeft(left);
        root.setRight(right);
        return root;
    }

    private int findRootIndex(int[] inOrder, int inS, int inE,int rootVal) {
        for (int i = inS; i <= inE; i++) {
            if (inOrder[i] == rootVal){
                return i;
            }
        }
        try {
            throw new IllegalAccessException("未找到");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
