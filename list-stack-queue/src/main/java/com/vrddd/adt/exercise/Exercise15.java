package com.vrddd.adt.exercise;

import com.vrddd.adt.list.MyLinkedList;

/**
 * 将linkedList2的元素，放到linkedList之前，并清除linkedList2
 */
public class Exercise15 {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList();
        linkedList.add(100000);
        MyLinkedList<Integer> linkedList2 = new MyLinkedList();
        linkedList2.add(11);
        linkedList2.add(14);
        linkedList2.add(13);
        MyLinkedList.splice(linkedList.listIterator(), linkedList2);
        System.out.println("输出linkedList1：");
        linkedList.printList();
        System.out.println("\n输出linkedList2：");
        linkedList2.printList();
    }
}
