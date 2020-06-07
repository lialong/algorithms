package com.vrddd.adt.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author lizelong
 * @date 2020/6/2
 */
public class MyArrayList<T> implements Iterable<T>{

    private T[] items;

    private int size;

    private static int DEFAULT_SIZE = 10;

    public MyArrayList(){
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int initSize){
        items = (T[])new Object[initSize];
    }

    private int size(){
        return this.size;
    }

    public T add(T item){
        return add(size(), item);
    }

    public T add(int idx, T item){
        if (size() == items.length){
            ensureCapacity(2 * size() + 1);
        }
        for (int i = size() + 1; i > idx ; i--) {
            items[i] = items[i-1];
        }
        items[idx] = item;
        this.size++;
        return item;
    }

    private void ensureCapacity(int newSize){
        if (newSize < size()){
            return;
        }
        T[] oldArr = items;
        T[] items = (T[])new Object[newSize];
        for (int i = 0; i < oldArr.length; i++) {
            items[i] = oldArr[i];
        }
    }

    public T remove(int idx){
        if (idx >= size()){
            throw new IndexOutOfBoundsException();
        }
        T old = items[idx];
        for (int i = idx; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        this.size--;
        return old;
    }

     public void trimToSize(){
        ensureCapacity(size());
     }

     @Override
     public Iterator<T> iterator(){
        return new MyArrayListIterator<>();
     }
    /**
     * 这里用的是private class即内部类，而不是private static class
     */
    private class MyArrayListIterator<T> implements Iterator<T> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            if (current <= size()){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return (T)(items[current++]);
        }

        @Override
        public void remove(){
            MyArrayList.this.remove(current);
        }
    }
}
