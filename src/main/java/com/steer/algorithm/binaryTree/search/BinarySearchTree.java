package com.steer.algorithm.binaryTree.search;

import com.steer.algorithm.binaryTree.Node;
import com.steer.algorithm.binaryTree.SearchTreeUtil;

/**
 * 二叉搜索树/排序树
 */
public class BinarySearchTree {
    Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public Node addNode(int value){
        return addNode(root,value);
    }

    /**
     * 添加节点
     * @param current
     * @param value
     * @return
     */
    private Node addNode(Node current, int value){
        if (current == null){
            return new Node(value);
        }
        if (value < current.getData()){
            current.setLeft(addNode(current.getLeft(),value));
        }else if (value > current.getData()){
            current.setRight(addNode(current.getRight(),value));
        }else{
            return current;
        }
        return current;
    }

    public boolean containNode(int value){
        return containNode(root, value);
    }

    /**
     * 查找节点
     * @param current
     * @param value
     * @return
     */
    private boolean containNode(Node current, int value){
        if (current == null){
            return false;
        }
        if (value == current.getData()){
            return true;
        }
        return value < current.getData() ? containNode(current.getLeft(), value):containNode(current.getRight(), value);
    }

    public Node deleteNode(int value){
        return deleteNode(root, value);
    }

    /**
     * 删除节点
     * 去删除节点的右子树中寻找最小的节点来代替删除节点的位置
     *
     * (可以使用中序遍历中的该删除节点前驱或者后继节点来代替该位置)
     *
     * 1.删除的为叶子节点:直接删除，并且把父节点的指向设置为Null
     * 2.删除的节点为单支节点:父节点指向该节点的子树
     * 3.删除的节点为双支节点:查找右子树的最小节点(肯定是叶子节点或单支节点)，替换；然后那个最小节点的父节点指向该节点的子树
     * @param current
     * @param value
     * @return
     */
    private Node deleteNode(Node current, int value){
        if (current == null){
            return null;
        }
        if (value == current.getData()){
            /**
             * 下面3个if 用于返回递归上一次层
             */
            //情况1:删除的节点为叶子节点
            if (current.getLeft() == null && current.getRight() == null){
                return null;
            }
            //情况2:删除的节点为单节点
            if (current.getLeft() == null){
                return current.getRight();
            }
            if (current.getRight() == null){
                return current.getLeft();
            }
            //情况3:删除的节点左右都有节点。找该节点的右子树的最小值，替换，然后删除该右子树最小值的节点
            int smallestValue = SearchTreeUtil.findSmallestValue(current.getRight());
            current.setData(smallestValue);
            current.setRight(deleteNode(current.getRight(), smallestValue));
            return current;
        }

        if (value < current.getData()){
            current.setLeft(deleteNode(current.getLeft(),value));
            return current;
        }

        current.setRight(deleteNode(current.getRight(),value));
        return current;
    }

}
