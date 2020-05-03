package com.steer.algorithm.list.oneway;

import com.steer.algorithm.list.ListUtils;
import com.steer.algorithm.list.OnewayNode;
import org.junit.jupiter.api.Test;

/**
 * 给定一单向有序链表
 * 若出现重复元素，则全部删除
 * eg.给定1->2->3->3->4->4->5 ,返回1->2->5;
 */
public class TestA {

    @Test
    public void test(){
        OnewayNode node = new OnewayNode(1);
        node.addNextNode(new OnewayNode(2))
                .addNextNode(new OnewayNode(3))
                .addNextNode(new OnewayNode(3))
                .addNextNode(new OnewayNode(4))
                .addNextNode(new OnewayNode(4))
                .addNextNode(new OnewayNode(5));
        System.out.println("======删除前======");
        ListUtils.printOnewayNode(node);
        System.out.println("\n======删除后======");

        //定义2个指针,一前一后
        OnewayNode curNode = node;
        OnewayNode nextNode = node.getNextNode();

        while (nextNode.getNextNode() != null){
            if (nextNode.getValue() == nextNode.getNextNode().getValue()){
                OnewayNode n = findNextNode(nextNode.getNextNode());
                curNode.setNextNode(n);
                nextNode = n;
            }else{
                curNode = nextNode;
                nextNode = nextNode.getNextNode();
            }
        }

        ListUtils.printOnewayNode(node);
    }

    /**
     * 查找下一个不重复节点
     * @param node
     * @return
     */
    private OnewayNode findNextNode(OnewayNode node){
        if (node == null){
            return null;
        }
        if (node.getNextNode() != null){
            OnewayNode nextNode = node.getNextNode();
            if (nextNode.getValue() == node.getValue()){
                return findNextNode(nextNode);
            }else{
                return nextNode;
            }
        }else {
            return null;
        }
    }
}
