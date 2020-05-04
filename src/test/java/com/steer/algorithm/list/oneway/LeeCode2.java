package com.steer.algorithm.list.oneway;

import com.steer.algorithm.list.ListUtils;
import com.steer.algorithm.list.OnewayNode;
import org.junit.jupiter.api.Test;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class LeeCode2 {
    @Test
    public void test(){
        OnewayNode node1 = new OnewayNode(2);
        node1.addNextNode(4).addNextNode(3);

        OnewayNode node2 = new OnewayNode(5);
        node2.addNextNode(6).addNextNode(4);

        OnewayNode newNode =  addTwoNumbers(node1,node2);

        ListUtils.printOnewayNode(newNode);
    }

    public OnewayNode addTwoNumbers(OnewayNode l1, OnewayNode l2) {
        OnewayNode newNode = new OnewayNode(0);
        //定义3个指针
        OnewayNode curN = newNode;
        OnewayNode p1 = l1;
        OnewayNode p2 = l2;
        //进位
        int p = 0;
        while(p1 !=null || p2 != null){
            //计算和
            int sum = (p1==null?0:p1.getValue())+(p2==null?0:p2.getValue())+p;
            //计算进位
            p = sum/10;
            curN.setNextNode(new OnewayNode(sum%10));
            curN = curN.getNextNode();

            p1 = (p1==null?null:p1.getNextNode());
            p2 = (p2==null?null:p2.getNextNode());
        }
        //最后判断是否还有多于的进位数
        if(p>0){
            curN.setNextNode(new OnewayNode(p));
        }
        return newNode.getNextNode();
    }
}
