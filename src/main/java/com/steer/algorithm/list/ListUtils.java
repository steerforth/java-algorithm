package com.steer.algorithm.list;

public class ListUtils {
    /**
     * 打印单向链表
     * @param node
     */
    public static void printOnewayNode(OnewayNode node) {
        System.out.print(node.getValue()+"\t");
        if (node.getNextNode() !=null){
            printOnewayNode(node.getNextNode());
        }
    }
}
