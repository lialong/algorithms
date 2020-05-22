package com.vrddd.introduction.excercise;

import java.util.Arrays;

/**
 * 练习14：一个有序集合
 */
public class OrderedCollection <T>{

    private Comparable<T>[] arr;
    private int size;

    public OrderedCollection(){
        this(10);
    }

    public OrderedCollection(int capacity){
        arr = new Comparable[capacity];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean makeEmpty(){
        try{
            size = 0;
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean remove(int i){
        try{
            for (int j = i+1; j < size; j++) {
                arr[j-1] = arr[j];
            }
            size--;
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public boolean insert(Comparable ele){
        try{
            if(size == arr.length){
                arr = Arrays.copyOf(arr,size * 2);
            }
            int i = 0;
            for (; i < size; i++) {
                if (ele.compareTo(arr[i]) < 0){
                    break;
                }
            }
            for (int j = size; j > i; j--) {
                arr[j] = arr[j-1];
            }
            arr[i] = ele;
            size++;
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public Comparable findMin(){
        if (size > 0){
            return arr[0];
        }else{
            return null;
        }
    }

    public Comparable findMax(){
        if (size > 0){
            return arr[size-1];
        }else{
            return null;
        }
    }
}
