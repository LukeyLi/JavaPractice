package org.lq.lzy.sort;

public class Hanoni {
    /**
     * n个盘子A到C
     * @param a
     * @param c
     * @param n
     */
    public static void Hanoi(int[] a,int[] c,int n) {
        if (n == 1) {
            move(a,c);
        }
        else {
            Hanoi(a, b, n-1);
            move(a,c);
            Hanonin(b,c,n-1);
        }
    }
}
