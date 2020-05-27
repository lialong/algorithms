package com.vrddd.analysis.maxsum;

/**
 * 时间复杂度为N，非常理想的算法
 */
public class MaxSubSeqSum4 {

    private static int getSum(int[] arr){
        int length = arr.length;
        int maxSum = 0, sum = 0;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            if (sum < 0){
                sum = 0;
            }else if( sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(new int[]{4,-3,5,-2,-1,2,6,-2}));
    }

}
