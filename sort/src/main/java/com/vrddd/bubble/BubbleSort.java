package com.vrddd.bubble;

import java.util.Arrays;

/**
 * 冒泡排序，交换排序
 * 为了将无序的一组数，变为有序。
 * 变升序。
 * 最坏判断 n*(n-1)/2 次，交换 n*(n-1)/2 次
 */
public class BubbleSort {
    /**
     * 待排序数组
     */
    private static final int[] arr = {32,453,123,43,556,12,312};
    /**
     * 执行完后，数组变升序
     * @param arr 待排序数组
     */
    public static void sort(int[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++){
                if (arr[j] > arr[j + 1]){
                    int mid = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = mid;
                }
            }
        }
    }

    public static void main(String[] args) {
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
