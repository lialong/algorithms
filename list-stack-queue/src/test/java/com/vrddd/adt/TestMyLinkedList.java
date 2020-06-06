package com.vrddd.adt;

import com.vrddd.adt.list.MyLinkedList;
import org.junit.Test;

public class TestMyLinkedList {
    @Test
    public void test(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(12);
        myLinkedList.add(13);
        myLinkedList.add(14);
        myLinkedList.add(15);
        myLinkedList.add(16);

        myLinkedList.add(0,11);
        myLinkedList.add(4,11);
        myLinkedList.printList();
        myLinkedList.remove(4);
        System.out.println();
        myLinkedList.printList();

        System.out.println("\n" + myLinkedList.get(5));

        System.out.println("1:" + myLinkedList.contains(1) + "," + "13:" + myLinkedList.contains(13));
    }
}
