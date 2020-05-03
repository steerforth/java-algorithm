package com.steer.algorithm.list;

/**
 * 单向链表节点
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
