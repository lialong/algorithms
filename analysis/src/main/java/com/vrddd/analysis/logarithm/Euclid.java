package com.vrddd.analysis.logarithm;

public class Euclid {

    private static int gcd(int m, int n){
        while(n != 0){
            int rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

}
