package com.steer.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeUtil {
    /**
     * 中序遍历(递归)
     * @param node
     */
    public static void traverseInOrder(Node node){
        if (node != null){
            traverseInOrder(node.getLeft());
            System.out.print(node.getData()+"\t");
            traverseInOrder(node.getRight());
        }
    }

    /**
     * 左-根-右
     * 中序遍历(迭代)
     * @param node
     */
    public static void traverseInOrderByIteration(Node node){
        Stack<Node> stack = new Stack<>();
        Node cur = node;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();
            System.out.print(cur.getData()+"\t");
            cur = cur.getRight();
        }
    }

    /**
     * 前序遍历
     * @param node
     */
    public static void traversePreOrder(Node node){
        if (node != null){
            System.out.print(node.getData()+"\t");
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }

    /**
     * 根-左-右
     * 前序遍历(迭代)
     * @param node
     */
    public static void traversePreOrderByIteration(Node node){
        Stack<Node> stack = new Stack<>();
        Node cur = node;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                System.out.print(cur.getData()+"\t");
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();
            cur = cur.getRight();
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    public static void traversePostOrder(Node node){
        if (node != null){
            traversePostOrder(node.getLeft());
            traversePostOrder(node.getRight());
            System.out.print(node.getData()+"\t");
        }
    }

    /**
     * 左-右-根
     * 后序遍历(迭代)
     * @param node
     */
    public static void traversePostOrderByIteration(Node node){
        Node cur = node;
//        Stack<Node> stack = new Stack<>();
//        Node cur = node;
//        while (cur != null || !stack.isEmpty()){
//            while (cur != null){
//                stack.push(cur);
//                cur = cur.getLeft();
//            }
//            cur = stack.pop();
//            System.out.print(cur.getData()+"\t");
//            cur = cur.getRight();
//        }
    }

    /**
     * 层次遍历
     * @param node
     */
    public static void traverseLevelOrder(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(node);
        while(!nodes.isEmpty()) {
            Node n = nodes.remove();
            System.out.print(n.getData()+"\t");
            if (n.getLeft() != null) {
                nodes.add(n.getLeft());
            }

            if (n.getRight() != null) {
                nodes.add(n.getRight());
            }
        }
    }

    /**
     * 获取某个节点的树高度
     * @param node
     * @return
     */
    public static int getChildDepth(Node node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(getChildDepth(node.getLeft()), getChildDepth(node.getRight()));
    }

    /**
     * 计算左子树和右子树的高度差
     * @param node
     * @return
     */
    public static int calDepthDiff(Node node){
        if (node == null){
            return 0;
        }
        return getChildDepth(node.getLeft())-getChildDepth(node.getRight());
    }


}
