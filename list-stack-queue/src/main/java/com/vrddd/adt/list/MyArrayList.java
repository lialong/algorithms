package com.vrddd.adt.list;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author lizelong
 * @date 2020/6/2
 */
public class MyArrayList<T> implements Iterable<T> {

    private T[] items;

    private int size;

    private static int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int initSize) {
        items = (T[]) new Object[initSize];
    }

    public int size() {
        return this.size;
    }

    public void set(int idx, T value){
        if (idx < 0 || idx >= size()){
            throw new NoSuchElementException();
        }
        items[idx] = value;
    }

    public T get(int idx) {
        if (idx >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return items[idx];
    }

    public int get(T item){
        for (int i = 0; i < size(); i++) {
            if (items[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    public T add(T item) {
        return add(size(), item);
    }

    public T add(int idx, T item) {
        if (size() == items.length) {
            ensureCapacity(2 * size() + 1);
        }
        for (int i = size(); i > idx; i--) {
            items[i] = items[i - 1];
        }
        items[idx] = item;
        this.size++;
        return item;
    }

    private void ensureCapacity(int newSize) {
        if (newSize < size()) {
            return;
        }
        T[] oldArr = items;
        T[] items = (T[]) new Object[newSize];
        for (int i = 0; i < size(); i++) {
            items[i] = oldArr[i];
        }
    }

    public T remove(int idx) {
        if (idx >= size()) {
            throw new IndexOutOfBoundsException();
        }
        T old = items[idx];
        for (int i = idx; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        this.size--;
        return old;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public void printList() {
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ",");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    public void addAll(Iterable<? extends T> items){
        Iterator<? extends T> iterator = items.iterator();
        while(iterator.hasNext()){
            add(iterator.next());
        }
    }

    public void removeAll(Iterable<? extends T> items){
        Iterator<? extends T> iterator = items.iterator();
        while(iterator.hasNext()){
            remove(get(iterator.next()));
        }
    }

    /**
     * 这里用的是private class即内部类，而不是private static class
     */
    private class MyArrayListIterator implements Iterator<T> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            if (current < size()) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }
    }

    public ListIterator<T> listIterator(){
        return new MyArrayListIterator2();
    }

    private class MyArrayListIterator2 implements ListIterator<T> {
        private int current;
        private boolean backwards = false;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new IndexOutOfBoundsException();
            }
            backwards = false;
            return items[current++];
        }

        @Override
        public boolean hasPrevious() {
            return current > 0 && current < size();
        }

        @Override
        public T previous() {
            if (!hasPrevious()){
                throw new IndexOutOfBoundsException();
            }
            backwards = true;
            return items[--current];
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            if (backwards){
                MyArrayList.this.remove(current--);
            }else {
                MyArrayList.this.remove(--current);
            }
        }

        @Override
        public void set(T t) {
            MyArrayList.this.set(current, t);
        }

        @Override
        public void add(T t) {
            MyArrayList.this.add(current++, t);
        }
    }
}
