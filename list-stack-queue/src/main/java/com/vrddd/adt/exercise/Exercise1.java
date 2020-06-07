package com.vrddd.adt.exercise;

import com.vrddd.adt.list.MyArrayList;

import java.util.Iterator;

/**
 * 只能使用Collection API中提供的方法，表P中元素值代表表L的索引，根据表P打印表L
 */
public class Exercise1 {
    public static void printLots(Iterable<Integer> iterableL, Iterable<Integer> iterableP){
        Iterator<Integer> iteratorL = iterableL.iterator();
        Iterator<Integer> iteratorP = iterableP.iterator();
        Integer pIndex = 0;
        int i = 0;
        while(iteratorP.hasNext()){
            pIndex = iteratorP.next();
            while(iteratorL.hasNext() && i < pIndex){
                iteratorL.next();
                i++;
            }
            if (iteratorL.hasNext()){
                System.out.println(iteratorL.next());
                i++;
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayListL = new MyArrayList<>();
        myArrayListL.add(11);
        myArrayListL.add(12);
        myArrayListL.add(13);
        myArrayListL.add(14);
        MyArrayList<Integer> myArrayListP = new MyArrayList<>();
        myArrayListP.add(1);
        myArrayListP.add(3);
        myArrayListP.add(5);
        printLots(myArrayListL, myArrayListP);
    }
}
