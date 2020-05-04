package com.steer.algorithm.list;

/**
 * 单向链表节点
 *
 * 常用解法:
 * 1.判断是否有环:定义2个指针指向起点，一快一慢，有环必会走到一起
 * 2.判断两条单链(分别为m,n长度)的相交节点：公共节点以后节点必重合
 * m长的节点先走m-n步(m>n)，然后一起走，判断是否相等，相等为公共节点
 */
public class OnewayNode {
    OnewayNode nextNode;
    int value;

    public OnewayNode(int value) {
        this.value = value;
    }

    public OnewayNode addNextNode(OnewayNode node){
        this.setNextNode(node);
        return node;
    }

    public OnewayNode addNextNode(int value){
        OnewayNode node = new OnewayNode(value);
        this.setNextNode(node);
        return node;
    }

    public OnewayNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(OnewayNode nextNode) {
        this.nextNode = nextNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
