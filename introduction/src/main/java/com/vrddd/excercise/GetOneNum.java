package com.vrddd.excercise;

public class GetOneNum {

    private static int get(int num){
        int i = 0;
        if (num != 0){
            i = num % 2;
            i += get(num / 2);
        }
        return i;
    }

    public static void main(String[] args) {
        int n = 31;
        System.out.println(get(n / 2));
    }

}
