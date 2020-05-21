package com.vrddd.introduction.excercise;

/**
 * 练习5：计算某个数的二进制表示中有多少个1
 * 奇数n中1的个数 = n/2中1的个数 + 1
 */
public class GetOneNum {

    private static int get(int num){
        if (num == 0){
            return 0;
        }else if (num%2 == 0){
            return get(num + 1) - 1;
        }else {
            return get(num/2) + 1;
        }
    }

    public static void main(String[] args) {
        int n = 31;
        System.out.println(get(n));
        n = 32;
        System.out.println(get(n));
    }

}
