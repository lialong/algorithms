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
        System.out.println("\n是否包含5：" + list.contains(5));
        System.out.println("是否包含1：" + list.contains(1));
        System.out.println("如果5存在，则移除后，size：" + list.size());
        list.removeIfContains(5);
        list.printList();

        list.removeIfContains(1);
        System.out.println("\n如果1存在，则移除后，size：" + list.size());
        list.printList();
    }
}
