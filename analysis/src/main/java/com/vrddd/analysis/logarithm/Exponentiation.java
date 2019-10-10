package com.vrddd.analysis.logarithm;

public class Exponentiation {

    private static int pow(int m, int n){
        if (n == 0){
            return 1;
        }else if(n == 1){
            return m;
        }else if (n % 2 == 0){
            return pow( m * m, n / 2);
        }else{
            return pow( m * m, n / 2) * m;
        }
    }

    public static void main(String[] args) {
        System.out.println(pow(2,3));
    }

}
