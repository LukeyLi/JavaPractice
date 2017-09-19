package org.lq.lzy.sort;

import java.util.Arrays;
import org.lzy.Utils.Util;


public class InsertionSort {
    public static void sort(int[] arr) {
        sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr, int low, int high) {
        // TODO Auto-generated method stub
        int key;
        int pre;
        for ( int j = low+1 ; j <= high ; j++) {
            key = arr[j];
            pre = j - 1;
            while(pre >= low && arr[pre] > key) {
                arr[pre+1] = arr[pre];
                pre--;
            }
            arr[pre+1] = key;
        }
    }
    public static void main(String[] args) {
        int[] arr = Util.getRandomArr( 2, 1, 100 );
        System.out.println( "begin..." + Arrays.toString( arr ) );
        sort( arr );
        System.out.println( "final..." + Arrays.toString( arr ) );
      }
}
