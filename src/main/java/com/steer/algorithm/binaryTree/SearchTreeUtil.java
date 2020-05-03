package com.steer.algorithm.binaryTree;

public class SearchTreeUtil extends TreeUtil {
    /**
     * 查询二叉搜索树最小的值
     * @param node
     * @return
     */
    public static int findSmallestValue(Node node) {
        return node.getLeft() == null ? node.getData() : findSmallestValue(node.getLeft());
    }
}
