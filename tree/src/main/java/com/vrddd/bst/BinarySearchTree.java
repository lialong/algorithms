package com.vrddd.bst;

import java.util.Comparator;

public class BinarySearchTree<T> {
    private Node root;

    private Comparator<T> comparator;

    public BinarySearchTree(){}

    public BinarySearchTree(Comparator<T> comparator){
        this.comparator = comparator;
    }

    private static class Node<T>{
        T value;
        Node left;
        Node right;

        Node(T value){
            this.value = value;
        }
    }

    public int compare(T t1, T t2){
        if (comparator == null){
            return ((Comparable)t1).compareTo(t2);
        }
        return comparator.compare(t1, t2);
    }

    public boolean contains(T t){
        return this.contains(t, root);
    }
    private boolean contains(T t, Node root){
        if (root == null){
            return false;
        }
        int compare = compare(t, (T)root.value);
        if (compare == 0){
            return true;
        }else if (compare < 0){
            return contains(t, root.left);
        }else {
            return contains(t, root.right);
        }
    }
    public void insert(T t){
        root = insert(t, root);
    }
    public Node insert(T t, Node root){
        if (root == null){
            return new Node(t);
        }
        int compare = compare(t, (T)root.value);
        if (compare < 0 ){
            root.left = insert(t, root.left);;
        }else if (compare > 0){
            root.right = insert(t, root.right);;
        }else {
            throw new RuntimeException("there is already a node has value:" + t);
        }
        return root;
    }
}
