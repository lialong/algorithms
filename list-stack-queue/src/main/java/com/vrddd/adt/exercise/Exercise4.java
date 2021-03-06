package com.vrddd.adt.exercise;

import com.vrddd.adt.list.MyArrayList;

/**
 * 表L1和表L2的交集
 */
public class Exercise4 {
    public static <T extends Comparable<? super T>> MyArrayList<T> getIntersection(MyArrayList<T> list1, MyArrayList<T> list2){
        int i=0,j=0;
        int length1 = list1.size();
        int length2 = list2.size();
        MyArrayList<T> list = new MyArrayList<>();
        while(i < length1 && j < length2){
            int compare = list1.get(i).compareTo(list2.get(j));
            if(compare < 0){
                i++;
            }else if (compare == 0){
                list.add(list1.get(i));
                i++;
                j++;
            }else {
                j++;
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
        list2.add(2);
        list2.add(3);
        MyArrayList<Integer> list = getIntersection(list1, list2);
        list.printList();
    }
}
