package com.vrddd.analysis.excercise;

import com.vrddd.analysis.excercise.entity.Sequence;

import java.util.ArrayList;
import java.util.List;

public class MaxSubSeqSum5 {

    private static Sequence getMaxSequence(int[] arr){
        int length = arr.length;
        List<Integer> list = new ArrayList<>(length);
        int sum = 0, maxSum = 0;
        Integer[] maxArr = new Integer[0];
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            list.add(arr[i]);
            if (sum < 0){
                sum = 0;
                list.clear();
            }else if(sum > maxSum){
                maxArr = list.toArray(new Integer[0]);
                maxSum = sum;
            }
        }
        Sequence sequence = new Sequence();
        sequence.setArr(maxArr);
        sequence.setSum(maxSum);
        return sequence;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,-3,5,-2,-1,2,6,-2};
        System.out.println(getMaxSequence(arr));
    }
}
