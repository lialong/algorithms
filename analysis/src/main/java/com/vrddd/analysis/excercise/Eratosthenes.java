package com.vrddd.analysis.excercise;

/**
 * 找出小于N的所有素数
 */
public class Eratosthenes {

    private static void find(int n){
        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            arr[i] = 1;
        }
        double num = Math.sqrt(n);
        for (int i = 2; i <= num ; i++) {
            int m,j;
            for (j = 2, m = j * i; m <= n; j++) {
                arr[m] = 0;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        find(2);
    }

}
