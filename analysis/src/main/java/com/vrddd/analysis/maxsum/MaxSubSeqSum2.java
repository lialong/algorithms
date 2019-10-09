package com.vrddd.analysis.maxsum;

public class MaxSubSeqSum2 {
    private static int getSum(int[] arr){
        int length = arr.length;
        int maxSum = 0;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += arr[j];
                if (sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(new int[]{4,-3,5,-2,-1,2,6,-2}));
    }
}
