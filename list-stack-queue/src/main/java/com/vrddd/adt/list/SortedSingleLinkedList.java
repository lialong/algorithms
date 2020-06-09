package com.vrddd.adt.list;

import java.util.Iterator;

/**
 * @author lizelong
 * @date 2020/6/9
 */
public class SortedSingleLinkedList<T extends Comparable<? super T>> implements Iterable<T>{
    private Node<T> beginMarker;
    private int size;

    public SortedSingleLinkedList(){
        doClear();
    }

    public void doClear(){
        this.size = 0;
        beginMarker = new Node<>(null, null);
    }

    @Override
    public Iterator<T> iterator() {
        return new SortedSingleLinkedListIterator();
    }

    private class SortedSingleLinkedListIterator implements Iterator<T>{
        private Node<T> current = beginMarker.next;
        private Node<T> before;
        private boolean rmFlag = false;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new IndexOutOfBoundsException();
            }
            T val = current.value;
            current = current.next;
            if (before != null){
                before = before.next;
            }else {
                before = beginMarker;
            }
            rmFlag = true;
            return val;
        }

        @Override
        public void remove(){
            if (rmFlag){
                SortedSingleLinkedList.this.remove(before);
                rmFlag = false;
            }
        }
    }

    private void remove(Node<T> before){
        before.next = before.next.next;
    }

    private static class Node<T>{
        T value;
        Node<T> next;

        Node(T value, Node<T> next){
            this.value = value;
            this.next = next;
        }
    }

    public int size(){
        return this.size;
    }

    public void printList(){
        Iterator<T> iterator = iterator();
        while(iterator.hasNext()){
            T val = iterator.next();
            System.out.print(val + " ");
        }
    }

    public boolean contains(T x){
        Iterator<T> iterator = iterator();
        while(iterator.hasNext()){
            T t = iterator.next();
            if (t.equals(x)){
                return true;
            }
        }
        return false;
    }

    public boolean putIfAbsent(T x){
        Node<T> node = beginMarker.next;
        Node<T> pre = beginMarker;
        while(node != null){
            int compare = x.compareTo(node.value);
            if (compare == 0){
                return false;
            }else if (compare < 0){
                addAfter(pre, x);
                return true;
            }else {
                node = node.next;
                pre = pre.next;
            }
        }
        addAfter(pre, x);
        return true;
    }

    private void addAfter(Node<T> node, T x){
        node.next = new Node(x, node.next);
        this.size++;
    }

    public boolean removeIfExist(T x){
        Iterator<T> iterator = iterator();
        while(iterator.hasNext()){
            T val = iterator.next();
            int compare = val.compareTo(x);
            if (compare == 0){
                iterator.remove();
                this.size--;
                return true;
            }else if (compare > 0){
                return false;
            }
        }
        return false;
    }
}
