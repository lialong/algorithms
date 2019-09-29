package com.vrddd.sort.selection;

import java.util.Arrays;

/**
 * 选择排序
 * 让一组数从小到大排列
 * 最坏判断 n*(n-1)/2 次，交换 (n-1) 次，但多用了一个变量记录
 */
public class SelectionSort {
    /**
     * 待排序数组
     */
    private static final int[] arr = {32,453,123,43,556,12,312};
    /**
     * 执行完后，数组变升序
     * @param arr 待排序数组
     */
    public static void sort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int mid = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = mid;
        }
    }

    public static void main(String[] args) {
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
