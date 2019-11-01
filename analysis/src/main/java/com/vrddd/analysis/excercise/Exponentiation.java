package com.vrddd.analysis.excercise;

public class Exponentiation {

    private static int[] getArray(int num, int pow){
        pow = (int)(Math.log(pow) / Math.log(2)) + 1;
        int[] arr = new int[pow];
        arr[0] = num;
        for (int i = 1; i < pow; i++) {
            arr[i] = arr[i - 1] * arr[i - 1];
        }
        return arr;
    }

    public static void main(String[] args) {
        int num = 2;
        int pow = 12;
        String binaryStr = Integer.toBinaryString(12);
        System.out.println(binaryStr);
        int[] arr = getArray(num, pow);
        int length = binaryStr.length() - 1;
        int sum = 1;
        for (int i = 0; i <= length; i++) {
            if (binaryStr.charAt(i) == '1'){
                sum *= arr[length - i];
            }
        }
        System.out.println(sum);
    }
}
