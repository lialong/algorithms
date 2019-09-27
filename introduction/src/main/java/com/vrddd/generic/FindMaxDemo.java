package com.vrddd.generic;

public class FindMaxDemo {

    public static Comparable findArrayMax(Comparable[] arr){
        int maxIndex = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if(arr[i].compareTo(arr[maxIndex]) > 0){
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    public static void main(String[] args) {
        String[] arr = {"123","321","312"};
        System.out.println(findArrayMax(arr));
    }

}
