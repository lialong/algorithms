package com.vrddd.analysis.excercise;
/**
 * 2.16
 */
public class GcdAlgorithm {

    private static int gcd(int m, int n){
        while(n > 0){
            int rem = m % n;
            m = n;
            n = rem;
        }
        return n;
    }



}
