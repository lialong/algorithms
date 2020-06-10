package com.vrddd.adt.list;

import java.util.ConcurrentModificationException;
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

    private int modCount;

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
        this.modCount++;
        return item;
    }

    private void ensureCapacity(int newSize) {
        if (newSize < size()) {
            return;
        }
        T[] oldArr = items;
        items = (T[]) new Object[newSize];
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
        this.modCount++;
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

    public void addAll(Iterable<? extends T> items){
        Iterator<? extends T> iterator = items.iterator();
        while(iterator.hasNext()){
            add(iterator.next());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    /**
     * 这里用的是private class即内部类，而不是private static class
     */
    private class MyArrayListIterator implements Iterator<T> {
        int current;
        int expectedModCount = modCount;
        int lastRet = -1;

        @Override
        public boolean hasNext() {
            return current != size();
        }

        @Override
        public T next() {
            checkModified();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastRet = current;
            return items[current++];
        }

        @Override
        public void remove() {
            checkModified();
            MyArrayList.this.remove(lastRet);
            lastRet = -1;
            expectedModCount++;
        }

        protected void checkModified(){
            if (expectedModCount != modCount){
                throw new ConcurrentModificationException();
            }
        }
    }

    public ListIterator<T> listIterator(){
        return new MyArrayListIterator2();
    }

    private class MyArrayListIterator2 extends MyArrayListIterator implements ListIterator<T> {
        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public T previous() {
            checkModified();
            if (!hasPrevious()){
                throw new IndexOutOfBoundsException();
            }
            return items[lastRet = --current];
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
        public void set(T t) {
            checkModified();
            MyArrayList.this.set(lastRet, t);
        }

        @Override
        public void add(T t) {
            checkModified();
            MyArrayList.this.add(current++, t);
            lastRet = -1;
            expectedModCount++;
        }
    }

    public Iterator<T> reverseIterator(){
        return new ArrayListReverseIterator();
    }

    private class ArrayListReverseIterator implements Iterator<T>{
        private int current = size() - 1;
        private int expectedModCount = modCount;

        private void checkModified(){
            if (expectedModCount != modCount){
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            return current > -1;
        }

        @Override
        public T next() {
            checkModified();
            if (!hasNext()){
                throw new IndexOutOfBoundsException();
            }
            return items[current--];
        }
    }
}
