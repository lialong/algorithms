package com.vrddd.adt.exercise;

import com.vrddd.adt.list.SingleLinkedList;

/**
 * 单链表实现
 */
public class Exercise11<T> {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.putIfAbsent(1);
        list.putIfAbsent(2);
        list.putIfAbsent(3);
        list.putIfAbsent(4);
        list.printList();
        System.out.println(list.contains(5));
        System.out.println(list.contains(1));
        list.removeIfContains(5);
        list.printList();
        list.removeIfContains(1);
        list.printList();
    }
}
