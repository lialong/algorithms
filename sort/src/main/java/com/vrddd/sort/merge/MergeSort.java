package com.vrddd.sort.merge;

import java.util.Arrays;

/**
 * 归并排序
 * 两个有序数组，通过归并方法，得到一个新的有序数组
 */
public class MergeSort {
    /**
     * 待排序数组
     */
    private static final int[] arr = {32,453,123,43,556,12,312};
    /**
     * 执行完后，数组变升序
     * @param arr 待排序数组
     * @param start 数组起始位置
     * @param end 数组终止位置
     */
    public static void sort(int[] arr,int start,int end){
        if (end - start > 0){
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr,mid + 1, end);
            merge(arr, start, mid, mid + 1, end);
        }
    }

    public static void merge(int[] arr,int s1,int e1,int s2,int e2){
        int length = e1 - s1 + e2 - s2 + 2;
        int[] temp = new int[length];
        int i = s1,j = s2,k = 0;
        while(i <= e1 && j <= e2){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while(i <= e1) {
            temp[k++] = arr[i++];
        }
        while(j <= e2) {
            temp[k++] = arr[j++];
        }
        int m = 0;
        for (int n = s1; n <= e1; n++) {
            arr[n] = temp[m++];
        }
        for (int p = s2; p <= e2; p++) {
            arr[p] = temp[m++];
        }
    }

    public static void main(String[] args) {
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
