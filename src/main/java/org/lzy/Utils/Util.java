package org.lzy.Utils;

import org.assertj.core.util.Preconditions;

import java.util.Arrays;
import java.util.Random;

public class Util {
  /**
   * 获取指定范围指定个数的随机数组成的数组
   *
   * @param length
   * @param min
   * @param max
   * @return
   */
  public static int[] getRandomArr(int length, int min, int max) {
    int[] arr = new int[length];
    for (int i = 0; i < length; i++) {
      arr[i] = (int) (Math.random() * (max + 1 - min) + min);
    }
    return arr;
  }

  public static int[] getRandomArrWithoutRepetition(int length, int min, int max) {
    int[] arr = new int[length];
    int i = 0;
    while (i < length) {
      int tmp = (int) (new Random().nextDouble() * (max + 1 - min) + min);
      if (indexOf( arr, tmp ) == -1) {
        arr[i] = tmp;
        i++;
      }
    }
    return arr;
  }

  /**
   * 在数组内原址交换元素
   *
   * @param arr
   * @param i
   * @param j
   */
  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  /**
   * 求元素下标
   *
   * @param arr
   * @param e
   * @return
   */
  public static int indexOf(int[] arr, int e) {
    Preconditions.checkNotNull( arr );
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == e) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 三区间划分法，返回数组的第一个数字是第一个小于等于主元的位置，第二个数字是第一个大于主元的位置
   *
   * @param arr
   * @param p
   * @param r
   * @return
   */
  public static int[] partition3(int[] arr, int p, int r, int pivot) {

    int next_less_pos = p;// 指向等于主元的第一个元素，“等于”区间的头指针，其实也是“小于”区间的末指针的下一个指针
    int next_bigger_pos = r;// 指向未知的最后一个元素，其后是确认大于主元的区间，“未知”区间的末指针
    int next_scan_pos = p; // 从第一个元素开始扫描
    while (next_scan_pos <= next_bigger_pos) {
      if (arr[next_scan_pos] < pivot) { // 扫描到的元素小于主元，将当前元素挪到“等于”区间的前面
        Util.swap( arr, next_scan_pos, next_less_pos );
        next_less_pos++; // “等于”区间的头指针向后移
        next_scan_pos++; // 扫描指针后移
      } else if (arr[next_scan_pos] > pivot) { // 扫描到的元素大于主元，交换当前元素和“未知”区间的末指针
        Util.swap( arr, next_scan_pos, next_bigger_pos );
        next_bigger_pos--; // 未知区间末指针前移，这是扫描指针不能后移
      } else {
        next_scan_pos++; // 相等，“等于”区间加长了，但是“等于”区间的头指针和“未知”区间的末指针都不必移动
      }
    }
    if (next_bigger_pos < 0) {
      next_bigger_pos = 0;
    }
    if (arr[next_bigger_pos] > pivot) {
      System.out.println( "..." + next_less_pos + "..." + (next_bigger_pos) + "..." + Arrays.toString( arr ) );
      return new int[]{next_less_pos, next_bigger_pos};
    } else {
      System.out.println( "..." + next_less_pos + "..." + (next_bigger_pos + 1) + "..." + Arrays.toString( arr ) );
      return new int[]{next_less_pos, next_bigger_pos + 1};
    }
  }

  public static boolean isOdd(int i) {
    return (i & 1) == 1;
  }

  /**
   * 打印矩阵
   * @param mat
   */
  public static void printMat(int[][] mat) {
    for (int[] arr : mat) {
      for (int e : arr) {
        System.out.print( e + "\t" );
      }
      System.out.println();
    }
  }

  public static String arrayToString(int[] arr) {
    StringBuilder sb = new StringBuilder();
    for (int e : arr
        ) {
      sb.append( e );
    }
    return sb.toString();
  }

  public static int maxOf(int[] arr) {
    Preconditions.checkNotNull( arr );
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  public static void print(int[] arr) {
    System.out.println( Arrays.toString( arr ) );
  }

  /**
   * 检查数组是否有序
   * @param arr 数组
   * @param isAsc 正序
   * @return
   */
  public static boolean checkOrdered(int[] arr, boolean isAsc) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1] && isAsc)
        return false;
      if (arr[i] < arr[i + 1] && !isAsc)
        return false;
    }
    return true;
  }

  /**
   * 获取数字src在d位上的数值，从个位开始计数
   * 个位：src/1 % 10
   * 十位：sec/10 %10
   *
   * @param src
   * @param d
   * @return
   */
  public static int getDigitOn(int src, int d) {
    return src / (int) (Math.pow( 10, d - 1 )) % 10;
  }
}