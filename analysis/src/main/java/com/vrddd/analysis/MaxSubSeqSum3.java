package com.vrddd.analysis;

public class MaxSubSeqSum3 {

    private static int getSum(int[] arr, int start, int end){
        if (start < end){
            int mid = (start + end) / 2;
            int left = getSum(arr, start, mid);
            int right = getSum(arr, mid + 1, end);
            int midSum = getLeftMax(arr,mid) + getRightMax(arr,mid);
            if (left >= right && left >= midSum){
                return left;
            }else if(right >= left && right >= midSum){
                return right;
            }else{
                return midSum;
            }
        }else if (start == end){
            return arr[start];
        }else {
            return 0;
        }
    }

    private static int getLeftMax(int[] arr,int mid){
        int maxSum = 0;
        int sum = 0;
        for (int i = mid; i >= 0; i--) {
            sum += arr[i];
            if (sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    private static int getRightMax(int[] arr,int mid){
        int maxSum = 0;
        int sum = 0;
        int length = arr.length;
        for (int i = mid + 1; i < length; i++) {
            sum += arr[i];
            if (sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,-3,5,-2,-1,2,6,-2};
        System.out.println(getSum(arr, 0, arr.length - 1));
    }

}
