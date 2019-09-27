package com.vrddd.recursion;

public class DoublePrintOut {

    private static void printDigit(int i){
        System.out.print(i);
    }

    private static void printOut(int i){
        if (i/10 > 0){
            printOut(i/10);;
        }
        printDigit(i%10);
    }

    private static void printPoint(double a){
        double d = a * 10;
        int i = (int)d;
        double b = d - i;
        printDigit(i);
        if (b > 0){
            printPoint(b);
        }
    }

    private static void printDouble(double a){
        int b = (int)a;
        printOut(b);
        System.out.print(".");
        a -= b;
        printPoint(a);
    }

    public static void main(String[] args) {
        printDouble(123.746d);
    }

}
