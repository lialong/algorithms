package com.vrddd.adt.exercise;

import com.vrddd.adt.list.MyArrayList;

import java.util.ListIterator;

/**
 * 测试ArrayList的listIterator
 */
public class Exercise13 {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(11);
        myArrayList.add(12);
        myArrayList.add(13);
        myArrayList.add(14);
        myArrayList.add(15);
        myArrayList.add(16);
        myArrayList.add(17);
        myArrayList.add(18);
        myArrayList.add(19);
        myArrayList.add(20);
        ListIterator<Integer> listIterator = myArrayList.listIterator();
        int i = 6;
        while(listIterator.hasNext() && i-- > 0){
            System.out.print(listIterator.next() + ",");
            if (i == 3){
                listIterator.remove();
                System.out.println("13移除了");
            }
        }
        System.out.println();
        while (listIterator.hasPrevious()){
            Integer val = listIterator.previous();
            System.out.print(val + ",");
            if (val == 14){
                listIterator.add(13);
            }
        }
        myArrayList.printList();
    }
}
