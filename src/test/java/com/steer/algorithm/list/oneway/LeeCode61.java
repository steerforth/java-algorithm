package com.steer.algorithm.list.oneway;

import com.steer.algorithm.list.ListUtils;
import com.steer.algorithm.list.OnewayNode;
import org.junit.jupiter.api.Test;

/**
 * 给定一个链表，旋转链表，将链表的每个节点向右移动k个未知，其中k是非负数.
 *
 * 输入:1->2->3->4->5->NULL,k=2
 * 输出:4->5->1->2->3->NULL
 */
public class LeeCode61 {

    /**
     * 将链表头尾相连，连成环
     *
     */
    @Test
    public void test(){
        OnewayNode node = new OnewayNode(1);
        node.addNextNode(2).addNextNode(3).addNextNode(4).addNextNode(5);

        System.out.println("===========移动前==========");
        ListUtils.printOnewayNode(node);

        int k = 6;
        OnewayNode newNode = moveRight(node, k);

        System.out.println("\n===========移动后==========");
        ListUtils.printOnewayNode(newNode);
    }

    private OnewayNode moveRight(OnewayNode head, int k) {
        if (head == null){
            return null;
        }
        //q指针，找tail
        OnewayNode q = head;
        int len = 1;
        while (q.getNextNode() != null){
            q = q.getNextNode();
            len++;
        }

        //连成环
        q.setNextNode(head);

        //p指针，在p指针后一位
        OnewayNode p = head;
        for (int i = 0; i < Math.abs(len-k%len); i++) {
            //双指针，指向一前一后
            q = p;
            p = p.getNextNode();
        }

        q.setNextNode(null);
        return p;
    }
}
