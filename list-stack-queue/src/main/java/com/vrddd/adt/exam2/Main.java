package com.vrddd.adt.exam2;

import java.util.*;

public class Main {

    private static List<Integer[]> cal2(List<Integer[]> list){
        if (list.size() == 0){
            return null;
        }
        TreeSet<Integer> set = new TreeSet<>();
        list.forEach(x -> {
            for (int i = x[0]; i <= x[1]; i++) {
                set.add(i);
            }
        });
        Integer min = list.get(0)[0];
        Integer max = list.get(0)[1];
        for (int i = 1; i < list.size(); i++) {
            min = list.get(i)[0] < min ? list.get(i)[0] : min;
            max = list.get(i)[1] > max ? list.get(i)[1] : max;
        }
        int length = max - min + 1;
        if (length == set.size()){
            List<Integer[]> result = new ArrayList<>(1);
            result.add(new Integer[]{min, max});
            return result;
        }else {
            return list;
        }
    }

    private static List<Integer[]> cal(List<Integer[]> arr){
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                Integer[] item = same(arr.get(i), arr.get(j));
                if (item != null){
                    list.add(item);
                }
            }
        }
        return list;
    }

    private static Integer[] same(Integer[] arr1, Integer[] arr2){
        if (arr1[1] >= arr2[0]) {
            return new Integer[]{arr2[0], arr1[1]};
        }else if(arr1[0] >= arr2[1]){
            return new Integer[]{arr2[1], arr1[0]};
        }else if(arr1[0] >= arr2[0] && arr1[1] <= arr2[1]){
            return arr2;
        }else if(arr2[0] >= arr1[0] && arr2[1] <= arr1[1]){
            return arr1;
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer[]> input = new ArrayList<>();
        int i = 0;
        while (in.hasNextInt()) {
            Integer str = in.nextInt();
            if (i % 2 == 0){
                Integer[] inArr = new Integer[2];
                inArr[0] = str;
                input.add(inArr);
            }else {
                input.get(i / 2)[1] = str;
            }
            i++;
        }
        List<Integer[]> list = cal(input);
        List<Integer[]> result = cal2(list);
        if (result == null){
            System.out.println("None");
        }else {
            result.forEach(x -> {
                System.out.println(x[0] + " " + x[1]);
            });
        }
    }
}
