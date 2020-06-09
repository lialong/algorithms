package com.vrddd.adt.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author lizelong
 * @date 2020/6/2
 */
public class MyLinkedList<T> implements Iterable<T>{

    private int size;
    private Node<T> beginMarker;
    private Node<T> endMarker;
    private int modCount;

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    public ListIterator<T> listIterator(){
        return new MyLinkedListIterator2();
    }

    private class MyLinkedListIterator implements Iterator<T>{
        Node<T> current = beginMarker.next;
        private boolean rmFlag = false;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {
            if (modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if (!hasNext()){
                throw new NullPointerException();
            }
            T val = current.value;
            current = current.next;
            rmFlag = true;
            return val;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if (!rmFlag){
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.pre);
            expectedModCount++;
            rmFlag = false;
        }
    }

    private class MyLinkedListIterator2 implements ListIterator<T>{
        private Node<T> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean backwards = false;
        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount){
                throw new ConcurrentModificationException();
            }
            return current != endMarker;
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new IndexOutOfBoundsException();
            }
            if (expectedModCount != modCount){
                throw new ConcurrentModificationException();
            }
            backwards = false;
            T val = current.value;
            current = current.next;
            return val;
        }

        @Override
        public boolean hasPrevious() {
            if (expectedModCount != modCount){
                throw new ConcurrentModificationException();
            }
            backwards = true;
            return current.pre != beginMarker;
        }

        @Override
        public T previous() {
            if (!hasPrevious()){
                throw new IndexOutOfBoundsException();
            }
            if (expectedModCount != modCount){
                throw new ConcurrentModificationException();
            }
            current = current.pre;
            return current.value;
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
            if (expectedModCount != modCount){
                throw new ConcurrentModificationException();
            }
            if (!backwards){
                MyLinkedList.this.remove(current.pre);
                expectedModCount++;
            }else {
                MyLinkedList.this.remove(current);
                current = current.pre;
                expectedModCount++;
            }
        }

        @Override
        public void set(T t) {
            if (expectedModCount != modCount){
                throw new ConcurrentModificationException();
            }
            current.value = t;
        }

        @Override
        public void add(T t) {
            if (expectedModCount != modCount){
                throw new ConcurrentModificationException();
            }
            expectedModCount++;
            addBefore(current, t);
        }
    }

    private static class Node<T>{
        private Node<T> pre;
        private Node<T> next;
        private T value;

        public Node(T value, Node<T> pre, Node<T> next){
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    public MyLinkedList(){
        doClear();
    }

    public int size(){
        return size;
    }

    public void doClear(){
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;
        this.size = 0;
        this.modCount++;
    }

    public boolean add(T t){
        add(size(), t);
        return true;
    }

    public void add(int idx, T t){
        addBefore(getNode(idx, 0, size()), t);
    }

    private Node<T> addBefore(Node<T> p, T t){
        Node<T> node = new Node<>(t, p.pre, p);
        p.pre.next = node;
        p.pre = node;
        this.size++;
        this.modCount++;
        return node;
    }

    public T get(int idx){
        return getNode(idx).value;
    }

    public boolean remove(int idx){
        remove(getNode(idx));
        return false;
    }

    private void remove(Node<T> node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        this.size--;
        this.modCount++;
    }

    private boolean remove(T val){
        Iterator<T> iterator = iterator();
        while(iterator.hasNext()){
            if (val.equals(iterator.next())){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public void removeAll(Iterable<? extends T> items){
        Iterator<? extends T> iterator = items.iterator();
        while(iterator.hasNext()){
            T val = iterator.next();
            remove(val);
        }
    }

    public boolean contains(T t){
        Iterator<T> iterator = iterator();
        while(iterator.hasNext()){
            T val = iterator.next();
            if (val.equals(t)) {
                return true;
            }
        }
        return false;
    }

    private Node<T> getNode(int idx){
        return getNode(idx, 0, size() - 1);
    }

    private Node<T> getNode(int idx, int low, int high){
        if (idx < low || idx > high){
            throw new IndexOutOfBoundsException();
        }
        int mid = size() / 2;
        Node<T> node;
        if (idx <= mid){
            node = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                node = node.next;
            }
        }else {
            node = endMarker;
            for (int i = size(); i > idx ; i--) {
                node = node.pre;
            }
        }
        return node;
    }

    public void printList(){
        Node<T> node = beginMarker.next;
        for (int i = 0; i < size(); i++) {
            System.out.print(node.value + "  ");
            node = node.next;
        }
    }

}
