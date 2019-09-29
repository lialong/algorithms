package com.vrddd.sort.quick;

import java.util.Arrays;

/**
 * 快速排序另外写法
 */
public class QuickSort2 {
    /**
     * 待排序数组
     */
    private static final int[] arr = {32,453,123,43,556,12,312};
    /**
     * 执行完后，数组变升序
     * @param arr 待排序数组
     * @param start 起始索引
     * @param end 终止索引
     */
    public static void sort(int[] arr,int start,int end){
        if (start < end){
            int pivot = partition(arr,start,end);
            sort(arr,start,pivot - 1);
            sort(arr,pivot + 1,end);
        }
    }
    /**
     *
     * @param arr 待排序数组
     * @param start 起始索引
     * @param end 终止索引
     */
    public static int partition(int[] arr,int start,int end){
        int key = arr[start];
        int i = start + 1;
        for (int j = start + 1; j <= end; j++) {
            if (arr[j] < key){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,start,i-1);
        return i-1;
    }
    /**
     * 数组值交换
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr,int a,int b){
        int c = arr[b];
        arr[b] = arr[a];
        arr[a] = c;
    }

    public static void main(String[] args) {
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
