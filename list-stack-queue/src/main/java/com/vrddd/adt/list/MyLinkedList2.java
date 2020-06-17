package com.vrddd.adt.list;

/**
 * 不用头节点、尾节点重写LinkedList
 */
public class MyLinkedList2<T> {
    private int size;
    private Node<T> first;

    private static class Node<T>{
        T value;
        Node<T> pre;
        Node<T> next;

        Node(T value, Node<T> pre, Node<T> next){
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }

    public int size(){
        return this.size;
    }

    public void insert(T t){
        if (first == null){
            first = new Node<>(t, null, null);
            this.size++;
        }else {
            insert(size, t);
        }
    }

    public void insert(int index, T t){
        if (index == size){
            Node<T> p = getNode(size - 1);
            Node<T> newNode = new Node<>(t, p, null);
            p.next = newNode;
            this.size++;
        }else if(index == 0){
            Node<T> newNode = new Node<>(t, null, first);
            first.pre = newNode;
            first = newNode;
            this.size++;
        }else {
            insertBefore(getNode(index), t);
        }
    }

    private void insertBefore(Node<T> p, T t){
        Node<T> newNode = new Node<>(t, p.pre, p);
        p.pre.next = newNode;
        p.pre = newNode;
        this.size++;
    }

    private void insertAfter(Node<T> p, T t){
        Node<T> newNode = new Node<>(t, p, p.next);
        p.next.pre = newNode;
        p.next = newNode;
        this.size++;
    }

    private Node<T> getNode(int index){
        if (index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public boolean delete(T t){
        Node<T> node = first;
        while (node != null){
            if (node.value.equals(t)){
                node.pre.next = node.next;
                node.next.pre = node.pre;
                this.size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void deleteByIndex(int index){
        if (index == 0){
            first = getNode(index + 1);
        }else if (index == size - 1){
            getNode(size - 2).next = null;
        }else {
            Node<T> node = getNode(index);
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    public void update(int index, T t){
        getNode(index).value = t;
    }

    public T get(int index){
        return getNode(index).value;
    }

    public void printList(){
        Node<T> node = first;
        while(node != null){
            System.out.print(node.value + ",");
            node = node.next;
        }
        System.out.println();
    }
}
