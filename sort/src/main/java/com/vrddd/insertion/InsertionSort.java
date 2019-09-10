package com.vrddd.insertion;

import java.util.Arrays;

public class InsertionSort {
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
        for (int i = 1; i < len; i++) {
            int ele = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] > ele){
                    for (int k = i; k > j; k--) {
                        arr[k] = arr[k-1];
                    }
                    arr[j] = ele;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
