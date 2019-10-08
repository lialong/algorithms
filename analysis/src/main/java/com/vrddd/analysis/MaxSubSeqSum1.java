package com.vrddd.analysis;

public class MaxSubSeqSum1 {

    private static int getSum(int[] arr){
        int length = arr.length;
        int maxSum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += arr[k];
                }
                if (thisSum > maxSum){
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(new int[]{4,-3,5,-2,-1,2,6,-2}));
    }

}
