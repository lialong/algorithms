package com.vrddd.adt.exercise;

import com.vrddd.adt.list.MyLinkedList;

import java.util.ListIterator;

/**
 * 测试LinkedList的listIterator
 */
public class Exercise14 {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(11);
        myLinkedList.add(12);
        myLinkedList.add(13);
        myLinkedList.add(14);
        myLinkedList.add(15);
        myLinkedList.add(16);
        myLinkedList.add(17);
        myLinkedList.add(18);
        myLinkedList.add(19);
        myLinkedList.add(20);
        ListIterator<Integer> listIterator = myLinkedList.listIterator();
        int i = 6;
        while(listIterator.hasNext() && i-- > 0){
            System.out.print(listIterator.next() + ",");
            if (i == 3){
                listIterator.remove();
                System.out.println("13被移除了");
            }
        }
        System.out.println();
        while(listIterator.hasPrevious()){
            Integer val = listIterator.previous();
            System.out.print(val + ",");
            if (val == 14){
                listIterator.add(13);
            }
        }
    }
}
