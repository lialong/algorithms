package com.vrddd.adt.list;

public class MyLazyDelLinkedList<T> {
    private int size;
    private int notDeletedSize;
    private int deletedSize;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    private static class Node<T> {
        T val;
        Node<T> pre;
        Node<T> next;
        /**
         * true：已删除
         * false：未删除
         */
        boolean delFlag;

        Node(T val, Node<T> pre, Node<T> next){
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    public MyLazyDelLinkedList(){
        doClear();
    }

    public void doClear(){
        beginMarker = new Node<>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;
    }

    public void add(T t){
        add(notDeletedSize, t);
    }

    public void add(int index, T t){
        Node<T> node = getNode(index);
        if (this.size > 0 && node.pre.equals(t) && node.pre.delFlag){
            node.pre.delFlag = false;
        }else {
            addBefore(node, t);
        }
    }

    private void addBefore(Node<T> node, T t){
        Node<T> newNode = new Node<>(t, node.pre, node);
        node.pre.next = newNode;
        node.pre = newNode;
        this.size++;
        this.notDeletedSize++;
    }

    private Node<T> getNode(int index){
        if (index < 0 || index > notDeletedSize){
            throw new IndexOutOfBoundsException();
        }
        int beginIndex = 0, endIndex = notDeletedSize;
        int mid = (beginIndex + endIndex) / 2;
        if (index < mid){
            int i = beginIndex;
            Node<T> node = beginMarker.next;
            while (i < index) {
                if (!node.delFlag){
                    i++;
                }
                node = node.next;
            }
            return node;
        }else {
            int i = endIndex;
            Node<T> node = endMarker;
            while (i > index) {
                if (!node.delFlag){
                    i--;
                }
                node = node.pre;
            }
            return node;
        }
    }

    public void remove(int index){
        if (index < 0 || index >= notDeletedSize){
            throw new IndexOutOfBoundsException();
        }
        remove(getNode(index));
    }

    private void remove(Node<T> node){
        node.delFlag = true;
        this.deletedSize++;
        this.notDeletedSize--;
        if (deletedSize >= notDeletedSize){
            gc();
        }
    }

    private void realRemove(Node<T> node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        this.deletedSize--;
        this.size--;
    }

    private void gc(){
        Node<T> node = beginMarker.next;
        while (node != endMarker){
            if (node.delFlag){
                realRemove(node);
            }
            node = node.next;
        }
    }

    public T get(int index){
        return getNode(index).val;
    }

    public void printList(){
        Node<T> node = beginMarker.next;
        while (node != endMarker){
            if (!node.delFlag){
                System.out.print(node.val + ",");
            }
            node = node.next;
        }
        System.out.println();
    }

    public int size(){
        return notDeletedSize;
    }
}
