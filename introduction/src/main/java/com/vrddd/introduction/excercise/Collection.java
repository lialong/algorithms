package com.vrddd.introduction.excercise;

import java.util.Arrays;

/**
 * 练习13：一个数组实现的集合
 */
public class Collection {

    private Object[] arr;
    private int size;

    public Collection(){
        this(10);
    }

    public Collection(int capacity){
        arr = new Object[capacity];
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

    public boolean insert(Object e){
        try{
            if (size >= arr.length){
                arr = Arrays.copyOf(arr,size * 2);
            }
            arr[size++] = e;
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
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

    public boolean isPresent(Object e){
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(e)){
                return true;
            }
        }
        return false;
    }
}
