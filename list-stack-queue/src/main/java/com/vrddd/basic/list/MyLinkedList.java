package com.vrddd.basic.list;

/**
 * @author lizelong
 * @date 2020/6/2
 */
public class MyLinkedList<T> {

    private int size;

    private static class Node<T>{
        private Node<T> pre;
        private Node<T> next;
        private T value;
    }

    public int size(){
        return size;
    }
}
