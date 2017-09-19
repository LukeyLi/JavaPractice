package org.lq.lzy.sort;

import java.util.Arrays;

import org.assertj.core.api.Assertions;

import org.lzy.Utils.Util;

public class HeapSort {
    /**
     * 建立最大堆
     * @param arr
     */
    public static void makeMaxHeap(int[] arr) {
        int n = arr.length;
        if(n == 1) {
            return;
        }
        for(int i = n / 2 - 1 ; i >= 0; i--) {
            makeHeapFixDown(arr,i,n);
        }
    }

    /**
     * 假设某个节点的左右子树分别满足最大堆，现在检测该节点是否最大堆
     * 如果该节点不满足，向下沉，将它的最大子节点上浮，类似插入排序
     * @param arr
     * @param index  索引
     * @param length
     */
    private static void makeHeapFixDown(int[] arr, int index, int length) {
        int j = 2 * index + 1; //左孩子
        int temp = arr[index];
        while( j < length ) {
            if( j + 1 < length && arr[j] < arr[j+1] ) {//右子节点比左子节点大
                j++;
            }
            if( arr[j] > temp ) {
                arr[index] = arr[j];
                index = j; //站在子节点上
                j = 2 * index + 1;
            }
            else
                break;
        }
        arr[index] = temp;   
    }
    
    public static void sortHeap(int[] arr) {
        makeMaxHeap(arr);//建立最大顶点堆
        int n = arr.length;
        for (int i = n-1; i >= 1 ; i--) {
           org.lzy.Utils.Util.swap(arr, i, 0);
           makeHeapFixDown(arr, 0 , i);
        }
    }
    public static void main(String[] args) {
        int[] arr = Util.getRandomArr( 6, 1, 100 );
        System.out.println( "begin..." + Arrays.toString( arr ) );
        sortHeap( arr );
        
        System.out.println( "final..." + Arrays.toString( arr ) );
        Assertions.assertThat(Util.checkOrdered( arr, true ) ).isTrue();
      }
}
