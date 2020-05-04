package com.steer.algorithm.binaryHeap;

import com.steer.algorithm.heap.BinaryMaxHeap;
import org.junit.jupiter.api.Test;

/**
 * 二叉最大堆
 */
public class BinaryMaxHeapTest {
    @Test
    public void test(){
        BinaryMaxHeap maxHeap = new BinaryMaxHeap();
        maxHeap.insert(new Integer(10));
        maxHeap.insert(new Integer(20));
        maxHeap.insert(new Integer(80));
        maxHeap.insert(new Integer(40));
        maxHeap.insert(new Integer(60));
        maxHeap.insert(new Integer(50));
        maxHeap.print();
    }
}
