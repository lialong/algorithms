package com.vrddd.analysis.excercise;

/**
 * 2.15，二分法实践
 */
public class FindNumber {
    private static int binarySearch(int[] arr, int num, int start, int end){
        if (start < end){
            int mid = (start + end) / 2;
            if (arr[mid] == num){
                return mid;
            }else if(num < arr[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
            return binarySearch(arr, num, start, end);
        }else if(start == end){
            if (arr[start] == num){
                return start;
            }else {
                return -1;
            }
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,20};
        int num = 7;
        int position = binarySearch(arr, num, 0, arr.length - 1) + 1;
        System.out.println(num == position);
    }
}
