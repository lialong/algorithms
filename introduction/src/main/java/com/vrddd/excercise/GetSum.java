package com.vrddd.excercise;

public class GetSum {

    private static double get(int i){
        if (i > 0){
            double denominator = 1 / Math.pow(4, i);
            denominator += get(i - 1);
            return denominator;
        }else {
            return 1;
        }
    }

    private static double get1(int i){
        if (i > 0){
            double denominator = i / Math.pow(4, i);
            denominator += get1(i - 1);
            return denominator;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(get(2));
        System.out.println(get1(2));
    }

}
