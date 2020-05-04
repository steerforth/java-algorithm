package com.steer.algorithm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉堆
 * 最大堆
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
        //调整堆
        filterUp(size);
    }

    private void filterUp(int size) {
        int curIndex = size;
        //获取父节点位置
        int pIndex = (curIndex - 1)/2;
        //当前
        T tmp = mHeap.get(curIndex);
        while (curIndex > 0){
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
