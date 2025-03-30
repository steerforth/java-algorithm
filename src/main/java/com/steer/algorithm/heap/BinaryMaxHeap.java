package com.steer.algorithm.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 二叉堆
 * 最大堆
 *
 * 特性:父节点总是大于（或小于）子节点
 * 二叉堆总是完全二叉树
 *
 * 查找：
 * 父节点 = (i - 1) / 2
 * 左孩子 = i * 2 + 1
 * 右孩子 = i * 2 + 2
 */
public class BinaryMaxHeap<T extends Comparable<T>> {
    //动态数组
    private List<T> mHeap;

    public BinaryMaxHeap() {
        this.mHeap = new ArrayList<T>();
    }

    public void insert(T data){
        int size = mHeap.size();
        mHeap.add(data);
        //调整堆，size其实是下标
        filterUp(size);
    }
    //插入的数据不断和父节点比较，交换位置
    private void filterUp(int size) {
        int curIndex = size;
        //获取父节点位置
        int pIndex = (curIndex - 1)/2;
        //当前
        T tmp = mHeap.get(curIndex);
        while (curIndex > 0){
            //当前节点和父节点比大小
            int cmp = tmp.compareTo(mHeap.get(pIndex));
            if (cmp <=0){
                break;
            }else {
                //父节点值塞到当前节点处
                mHeap.set(curIndex,mHeap.get(pIndex));
                curIndex = pIndex;
                pIndex = (curIndex - 1)/2;
            }
        }

        mHeap.set(curIndex,tmp);
    }

    public void print(){
        this.mHeap.stream().forEach(e->{
            System.out.print(e+"\t");
        });
    }
}
