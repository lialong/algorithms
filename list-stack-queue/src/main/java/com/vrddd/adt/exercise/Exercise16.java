package com.vrddd.adt.exercise;

import com.vrddd.adt.list.MyArrayList;

import java.util.Iterator;

/**
 * 测试反向遍历迭代器
 */
public class Exercise16 {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList(3);
        list.add(11);
        list.add(12);
        list.add(13);
        Iterator<Integer> iterator = list.reverseIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
