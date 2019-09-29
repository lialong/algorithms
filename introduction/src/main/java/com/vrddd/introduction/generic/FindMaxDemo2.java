package com.vrddd.introduction.generic;

import java.util.Comparator;

public class FindMaxDemo2 {

    private static Comparator<String> ignoreCaseComparator = (x,y) -> x.compareToIgnoreCase(y);

    static class IgnoreStringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareToIgnoreCase(o2);
        }
    }

    public static <T> T findMax(T[] arr, Comparator<T> comparator){
        int length = arr.length;
        int maxIdx = 0;
        for (int i = 1; i < length; i++) {
            if (comparator.compare(arr[i], arr[maxIdx]) > 0){
                maxIdx = i;
            }
        }
        return arr[maxIdx];
    }

    public static void main(String[] args) {
        String[] arr = {"abc","cba","Bad"};
        System.out.println(findMax(arr, ignoreCaseComparator));
        System.out.println(findMax(arr, String::compareToIgnoreCase));
        System.out.println(findMax(arr, new IgnoreStringComparator()));
    }

}
