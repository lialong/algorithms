package com.vrddd.introduction.excercise;

import java.util.Arrays;

/**
 * 练习一：
 * 有N个元素的集合，取第K大的元素；
 * 简单思路就是倒排序，然后取第K个元素
 */
public class GetTopK {
    private static final Integer[] arr = {1,2,3,4,5,6,7,8,9,10};

    public static void main(String[] args) {
        int k = arr.length / 2;
        //此处正序排，故取 arr.length - k 处的元素
        Arrays.sort(arr);
        int index = arr.length - k;
        System.out.println(arr[index]);
    }
}
