package com.vrddd.adt.exercise;

import com.vrddd.adt.list.MyLinkedList;

/**
 * MyLinkedList增加addFirst、addLast、removeFirst、removeLast、getFirst、getLast方法
 */
public class Exercise18 {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(11);
        list.add(12);
        list.add(13);
        list.addFirst(10);
        System.out.println();
        list.printList();
        list.addLast(14);
        System.out.println();
        list.printList();
        list.removeFirst();
        System.out.println();
        list.printList();
        list.removeLast();
        System.out.println();
        list.printList();

        Integer first = list.getFirst();
        System.out.println("getFirst:" + first);

        Integer last = list.getLast();
        System.out.println("getLast:" + last);
    }
}
