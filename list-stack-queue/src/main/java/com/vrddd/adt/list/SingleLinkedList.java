package com.vrddd.adt.list;

/**
 * @author lizelong
 * @date 2020/6/9
 */
public class SingleLinkedList<T>{
    private Node<T> beginMarker;
    private int size;

    private static class Node<T>{
        T value;
        Node<T> next;

        Node(T value, Node<T> next){
            this.value = value;
            this.next = next;
        }
    }

    public SingleLinkedList(){
        doClear();
    }

    public void doClear(){
        this.size = 0;
        beginMarker = new Node(null, null);
    }

    public int size(){
        return this.size;
    }

    public void printList(){
        Node<T> node = beginMarker.next;
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public boolean contains(T t){
        Node<T> node = beginMarker.next;
        while(node != null){
            if (node.value.equals(t)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean putIfAbsent(T x){
        if (!contains(x)){
            Node<T> first = beginMarker.next;
            beginMarker.next = new Node<>(x, first);
            return true;
        }
        return false;
    }

    public boolean removeIfContains(T x){
        Node<T> pre = beginMarker;
        Node<T> node = beginMarker.next;
        while(node != null){
            if (node.value.equals(x)){
                pre.next = node.next;
                return true;
            }
            pre = node;
            node = node.next;
        }
        return false;
    }
}
