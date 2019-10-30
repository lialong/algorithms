package com.vrddd.analysis.excercise;

public class MaxSubSeqProduct {

    private static int getProduct(int[] arr){
        int length = arr.length;
        int maxProduct = 0;
        for (int i = 0; i < length; i++) {
            int product = 1;
            for (int j = i; j < length; j++) {
                product *= arr[j];
                if (product == 0){
                    break;
                }else if(product > maxProduct){
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(getProduct(new int[]{4,-3,5,-2,-1,1,2,6,-2}));
    }

}
