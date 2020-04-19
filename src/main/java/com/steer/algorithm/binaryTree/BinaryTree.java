package com.steer.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
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
        if (value < current.data){
            current.left = addNode(current.left,value);
        }else if (value > current.data){
            current.right = addNode(current.right,value);
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
        if (value == current.data){
            return true;
        }
        return value < current.data ? containNode(current.left, value):containNode(current.right, value);
    }

    public Node deleteNode(int value){
        return deleteNode(root, value);
    }

    /**
     * 删除节点
     * @param current
     * @param value
     * @return
     */
    private Node deleteNode(Node current, int value){
        if (current == null){
            return null;
        }
        if (value == current.data){
            /**
             * 下面3个if 用于返回递归上一次层
             */
            //判断子节点
            if (current.left == null && current.right == null){
                return null;
            }
            if (current.left == null){
                return current.right;
            }
            if (current.right == null){
                return current.left;
            }
            //查找右子树最小的值
            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = deleteNode(current.right, smallestValue);
            return current;
        }

        if (value < current.data){
            current.left = deleteNode(current.left,value);
            return current;
        }

        current.right = deleteNode(current.right,value);
        return current;
    }

    private int findSmallestValue(Node node) {
        return node.left == null ? node.data : findSmallestValue(node.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public void traverseInOrder(Node root){
        if (root != null){
            traverseInOrder(root.left);
            System.out.println(root.data);
            traverseInOrder(root.right);
        }
    }

    /**
     * 前序遍历
     * @param root
     */
    public void traversePreOrder(Node root){
        if (root != null){
            System.out.println(root.data);
            traverseInOrder(root.left);
            traverseInOrder(root.right);
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public void traversePostOrder(Node root){
        if (root != null){
            traverseInOrder(root.left);
            traverseInOrder(root.right);
            System.out.println(root.data);
        }
    }

    /**
     * 层次遍历
     * @param root
     */
    public void traverseLevelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.println(node.data);
            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.setRoot(new Node(35));

        tree.addNode(4);
        tree.addNode(15);
        tree.addNode(3);
        tree.addNode(1);
        tree.addNode(20);
        tree.addNode(8);
        tree.addNode(50);
        tree.addNode(30);
        tree.addNode(80);
        tree.addNode(70);

        tree.addNode(90);

//        tree.deleteNode(50);
        System.out.println("=====中序遍历=====");
        tree.traverseInOrder(tree.getRoot());
        System.out.println("=====前序遍历=====");
        tree.traversePreOrder(tree.getRoot());
        System.out.println("=====后序遍历=====");
        tree.traversePostOrder(tree.getRoot());
        System.out.println("=====层次遍历=====");
        tree.traverseLevelOrder(tree.getRoot());
    }
}
