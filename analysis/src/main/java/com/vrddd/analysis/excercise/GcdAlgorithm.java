package com.vrddd.analysis.excercise;
/**
 * 2.16
 */
public class GcdAlgorithm {

    private static int gcd(int m, int n){
        if (m > n){
            if (isEven(m) && isEven(n)){
                return  2 * gcd( m / 2, n / 2);
            }else if(isEven(m) && !isEven(n)){
                return  gcd( m / 2, n);
            }else if(!isEven(m) && isEven(n)){
                return  gcd( m, n / 2);
            }else{
                return  gcd( (m + n) / 2, (m - n) / 2);
            }
        }else if (m == n){
            return m;
        }else {
            return -1;
        }
    }

    private static boolean isEven(int num){
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(gcd(100, 25));
    }

}
