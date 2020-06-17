package com.vrddd.adt.exercise;

import com.vrddd.adt.list.MyLinkedList2;

/**
 * 测试无头尾节点的linkedList
 */
public class Exercise19 {
    public static void main(String[] args) {
        MyLinkedList2 list = new MyLinkedList2();
        list.insert(11);
        list.insert(12);
        list.insert(13);
        list.insert(14);
        list.printList();
        list.insert(0, 10);
        list.insert(list.size(), 15);
        list.printList();
        list.delete(11);
        list.printList();
        list.deleteByIndex(2);
        list.printList();
        System.out.println(list.get(0));
    }
}
