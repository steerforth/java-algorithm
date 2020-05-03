package com.steer.algorithm.binaryTree.search.avl;

import com.steer.algorithm.binaryTree.Node;
import com.steer.algorithm.binaryTree.SearchTreeUtil;
import com.steer.algorithm.binaryTree.TreeUtil;

/**
 * https://www.cs.usfca.edu/~galles/visualization/AVLtree.html
 */
public class AVLTree {
    Node root;
    //二叉树的高度
    public int height;

    public AVLTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node addNode(int value){
        Node node = addNode(root, value);
        return balance(node);
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

    public Node deleteNode(int value){
        Node node = deleteNode(root,value);
        return balance(node);
    }

    private Node deleteNode(Node current, int value) {
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

    private Node balance(Node current) {
       int depthDiff = TreeUtil.calDepthDiff(current);
       //不需要平衡
       if (depthDiff <= 1 && depthDiff >= -1 ){
           return current;
       }else if(depthDiff >= 2){ //左子树高
           if (TreeUtil.calDepthDiff(current.getLeft()) > 0){
               return getLLBalance(current);
           }else{
               return getLRBalance(current);
           }
       }else{//右子树高
           if (TreeUtil.calDepthDiff(current.getRight()) > 0){
               return getRLBalance(current);
           }else{
               return getRRBalance(current);
           }
       }
    }

    private Node getRRBalance(Node root) {
        Node newRoot = root.getRight();
        root.setRight(newRoot.getLeft());
        newRoot.setLeft(root);
        return newRoot;
    }

    private Node getRLBalance(Node root) {
        root.setRight(getLLBalance(root.getRight()));
        return getRRBalance(root);
    }

    private Node getLRBalance(Node root) {
        root.setLeft(getRRBalance(root.getLeft()));
        return getLLBalance(root);
    }

    private Node getLLBalance(Node root) {
        Node newRoot = root.getLeft();
        root.setLeft(newRoot.getRight());
        newRoot.setRight(root);
        return newRoot;
    }


}
