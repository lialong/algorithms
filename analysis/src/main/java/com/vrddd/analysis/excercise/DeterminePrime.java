package com.vrddd.analysis.excercise;

/**
 * 练习2.20
 * 判断某个数是否时素数
 */
public class DeterminePrime {

    private static boolean isPrime(int num){
        for (int i = 2; i < num; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 当m的平方大于n时，n对小于m的所有质数都除不尽，则说明n是质数
     * @param num
     * @return
     */
    private static boolean isPrime2(int num){
        if (num != 2 && num % 2 == 0){
            return false;
        }else{
            double n = Math.sqrt(num);
            for (int i = 3; i <= n; i++) {
                if (num % i == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime2(12));
    }
}
