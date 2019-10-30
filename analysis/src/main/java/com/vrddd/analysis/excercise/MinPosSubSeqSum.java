package com.vrddd.analysis.excercise;

public class MinPosSubSeqSum {

    private static int getSum(int[] arr){
        int length = arr.length;
        int sum = 0, minSum = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] > 0){
                sum += arr[i];
                if (minSum == 0){
                    minSum = sum;
                }else if(sum < minSum){
                    minSum = sum;
                }
            }else{
                sum = 0;
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(new int[]{4,-3,5,-2,-1,1,2,6,-2}));
    }
}
