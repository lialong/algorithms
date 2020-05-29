package com.vrddd.analysis.excercise;

/**
 * 习题：2.14
 *
 * @author lizelong
 * @date 2020/5/29
 */
public class Horner {

    private static double cal(double[] arr, double x){
        double poly = 0;
        for (int i = arr.length-1; i >= 0 ; i--) {
            poly = x * poly + arr[i];
        }
        return poly;
    }

    public static void main(String[] args) {
        double[] arr = {2, 1, 0, 8, 4};
        double x = 3;
        System.out.println(cal(arr, x));
    }
}
