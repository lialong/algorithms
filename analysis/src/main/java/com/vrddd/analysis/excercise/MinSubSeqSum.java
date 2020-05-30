package com.vrddd.analysis.excercise;

/**
 * 练习2.17
 * 求最小子序列
 */
public class MinSubSeqSum {

    private static int getSum(int[] arr){
        int length = arr.length;
        int sum = 0 , minSum = 0;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            if (sum > 0){
                sum = 0;
            }else if(sum < minSum){
                minSum = sum;
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(new int[]{4,-3,5,-2,-1,2,6,-2}));
    }

}
