package com.vrddd.quick;

import java.util.Arrays;

/**
 * 快速排序
 * 1，找个分界值，将数组分成两个，一个小于分界值，一个大于分界值
 * 2，通过递归，不断将数组分割，直至数组有序
 */
public class QuickSort {
    /**
     * 待排序数组
     */
    private static final int[] arr = {32,453,123,43,556,12,312};
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
    /**
     * 执行完后，数组变升序
     * @param arr 待排序数组
     * @param start 起始索引
     * @param end 终止索引
     */
    public static void sort(int[] arr,int start,int end){
        if (start < end){
            int key = arr[start];
            int i = start;
            int j = end;
            while(i < j){
                while(i < j && arr[i] < key) {
                    i++;
                }
                while(j > i && arr[j] > key) {
                    j--;
                }
                if (arr[i] == arr[j] && i < j){
                    i++;
                }
                swap(arr,i,j);
            }
            sort(arr,start,i);
            sort(arr,i+1,end);
        }
    }

    public static void main(String[] args) {
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
