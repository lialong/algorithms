package com.vrddd.analysis.excercise;

/**
 * 一个全为正数的数组，找出其中a[j]+a[i]、a[j]*a[i]、a[j]*a[i]、a[j]/a[i]的最大值（其中i<=j）
 */
public class MaximumFind {
    //找出最大的数，也就得出和、乘积的最大值
    public static int findMax(int[] arr){
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max]){
                max = i;
            }
        }
        return arr[max];
    }
    //对于a[j]/a[i]和a[j] - a[i]，i<=j
    public static int findSubMax(int[] arr){
        int min = arr[0];
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
            int num = arr[i] - min;
            if(num > max){
                max = num;
            }
        }
        return max;
    }
    public static int findDivMax(int[] arr){
        int min = arr[0];
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
            int num = arr[i] / min;
            if(num > max){
                max = num;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {13,2,1,4,5,6,7,7};
        System.out.println(findMax(arr));
        System.out.println(findSubMax(arr));
        System.out.println(findDivMax(arr));
    }
}
