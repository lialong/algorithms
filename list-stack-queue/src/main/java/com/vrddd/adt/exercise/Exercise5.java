package com.vrddd.adt.exercise;

import com.vrddd.adt.list.MyArrayList;

public class Exercise5 {
    public static <T extends Comparable<? super T>> MyArrayList<T> getUnion(MyArrayList<T> list1, MyArrayList<T> list2){
        int i=0,j=0;
        int length1 = list1.size();
        int length2 = list2.size();
        MyArrayList<T> list = new MyArrayList<>();
        while(i < length1 && j < length2){
            int compare = list1.get(i).compareTo(list2.get(j));
            if(compare < 0){
                list.add(list1.get(i));
                i++;
            }else if (compare == 0){
                list.add(list1.get(i));
                i++;
                j++;
            }else {
                list.add(list1.get(j));
                j++;
            }
        }
        if (i == length1){
            for (int k = j; k < length2; k++) {
                list.add(list2.get(k));
            }
        }else {
            for (int k = i; k < length1; k++) {
                list.add(list1.get(k));
            }
        }
        list.trimToSize();
        return list;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>(5);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        MyArrayList<Integer> list2 = new MyArrayList<>(2);
        list2.add(3);
        list2.add(17);
        MyArrayList<Integer> list = getUnion(list1, list2);
        list.printList();
    }
}
