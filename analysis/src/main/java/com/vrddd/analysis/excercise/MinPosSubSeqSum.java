package com.vrddd.analysis.excercise;

/**
 * 练习1.17
 * 暴力求解最小正数和子序列
 */
public class MinPosSubSeqSum {

    private static int getSum(int[] arr){
        int length = arr.length;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += arr[i];
                if (sum > 0 && sum < minSum) {
                    minSum = sum;
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(new int[]{4,-3,5,-2,-1,1,2,6,-2}));
    }
}
