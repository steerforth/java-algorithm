package com.steer.algorithm.list.oneway;

import com.steer.algorithm.list.ListUtils;
import com.steer.algorithm.list.OnewayNode;
import org.junit.jupiter.api.Test;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * （1 ≤ m ≤ n ≤ 链表长度
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL）
 */
public class LeeCode92 {

    /**
     * 双指针-头插法
     */
    @Test
    public void test(){
        OnewayNode node = new OnewayNode(1);
        node.addNextNode(2).addNextNode(3).addNextNode(4).addNextNode(5);
        System.out.println("=======翻转前=========");
        ListUtils.printOnewayNode(node);
        node = reverseBetween(node,2,4);

        System.out.println("\n=======翻转后=========");
        ListUtils.printOnewayNode(node);
    }

    /**
     *
     * @param head
     * @param m 表示第m个节点
     * @param n 表示第n个节点
     * @return
     */
    private OnewayNode reverseBetween(OnewayNode head, int m, int n) {
        OnewayNode onewayNode = new OnewayNode(0);
        onewayNode.setNextNode(head);

        //定义2个指针,p为m位置前一个节点，q为p后一个节点
        OnewayNode p = onewayNode;
        OnewayNode q = onewayNode.getNextNode();
        int step = 0;
        while (step < m-1){
            p = p.getNextNode();
            q = q.getNextNode();
            step++;
        }

        for (int i =0;i<n-m;i++) {
            //不断把q的下一个节点放到p的下一个节点的位置，来实现翻转
            OnewayNode temp = q.getNextNode();
            q.setNextNode(q.getNextNode().getNextNode());
            temp.setNextNode(p.getNextNode());
            p.setNextNode(temp);

        }

        return onewayNode.getNextNode();

    }
}
