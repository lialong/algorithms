package com.vrddd.adt.exercise;

import com.vrddd.adt.list.MyLazyDelLinkedList;

/**
 * 优点：删除操作变简单；删除的元素刚好是要插入的元素
 * 缺点：占用额外的空间
 */
public class Exercise20 {
    public static void main(String[] args) {
        MyLazyDelLinkedList<Integer> myLazyDelLinkedList = new MyLazyDelLinkedList<>();
        myLazyDelLinkedList.add(11);
        myLazyDelLinkedList.add(12);
        myLazyDelLinkedList.add(13);
        myLazyDelLinkedList.add(14);
        myLazyDelLinkedList.add(15);
        myLazyDelLinkedList.printList();
        myLazyDelLinkedList.remove(0);
        myLazyDelLinkedList.remove(1);
        myLazyDelLinkedList.remove(2);
        myLazyDelLinkedList.printList();

    }
}
