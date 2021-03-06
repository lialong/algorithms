package com.vrddd.analysis.logarithm;

/**
 * 二分查找法，算法复杂度为logN
 */
public class BinarySearch {

    private static int search(int[] arr, int start, int end, int num){
        if (start < end){
            int mid = (start + end) / 2;
            if (num > arr[mid]){
                return search(arr, mid+1, end, num);
            }else if(num == arr[mid]){
                return mid;
            }else{
                return search(arr, start, mid-1, num);
            }
        }else if (start > end){
            return -1;
        }else{
            return arr[start] == num ? start : -1;
        }
    }

    private static int search(int[] arr, int num){
        int start = 0, end = arr.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if (num < arr[mid]){
                end = mid - 1;
            }else if(num > arr[mid]){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,22,33,44,55,66};
        System.out.println(search(arr, 0, arr.length - 1, 66));
        System.out.println(search(arr, 66));

    }

}
