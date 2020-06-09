package com.vrddd.adt.exercise;

import com.vrddd.adt.list.SortedSingleLinkedList;

/**
 * @author lizelong
 * @date 2020/6/9
 */
public class Exercise12 {
    public static void main(String[] args) {
        SortedSingleLinkedList<Integer> list = new SortedSingleLinkedList<>();
        list.putIfAbsent(1);
        list.putIfAbsent(2);
        list.putIfAbsent(3);
        list.putIfAbsent(4);
        list.printList();
        System.out.println("\n是否包含5：" + list.contains(5));
        System.out.println("是否包含1：" + list.contains(1));
        System.out.println("如果5存在，则移除后，size：" + list.size());
        list.removeIfExist(5);
        list.printList();

        list.removeIfExist(3);
        System.out.println("\n如果3存在，则移除后，size：" + list.size());
        list.printList();
    }
}
