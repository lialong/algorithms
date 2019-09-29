package com.vrddd.introduction.recursion;

public class PrintOut {

    private static void printDigit(int i){
        System.out.println(i);
    }

    private static void printOut(int i){
        if (i/10 > 0){
            printOut(i/10);;
        }
        printDigit(i%10);
    }

    public static void main(String[] args) {
        printOut(12353231);
    }

}
