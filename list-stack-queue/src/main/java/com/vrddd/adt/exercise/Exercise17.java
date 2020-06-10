package com.vrddd.adt.exercise;

import com.vrddd.adt.list.MyArrayList;

import java.util.Iterator;

/**
 * MyArrayList的迭代器支持修改判断
 */
public class Exercise17 {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList(3);
        list.add(11);
        list.add(12);
        list.add(13);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            list.add(14);
        }
    }
}
