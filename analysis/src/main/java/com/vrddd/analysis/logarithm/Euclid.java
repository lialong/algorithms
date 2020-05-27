package com.vrddd.analysis.logarithm;

/**
 * 欧几里得算法求最大公约数
 * 算法复杂度为longN
 * M mod N < M/2，可知M%N永远小于M/2，所以时间复杂度为logN
 */
public class Euclid {

    private static int gcd(int m, int n){
        while(n != 0){
            int rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(gcd(50, 15));
    }

}
