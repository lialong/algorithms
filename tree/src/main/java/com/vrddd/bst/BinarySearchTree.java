package com.vrddd.bst;

import java.util.Comparator;

public class BinarySearchTree<T> {
    private Node<T> root;

    private Comparator<T> comparator;

    public BinarySearchTree(){}

    public BinarySearchTree(Comparator<T> comparator){
        this.comparator = comparator;
    }

    private static class Node<T>{
        T value;
        Node<T> left;
        Node<T> right;

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
    private boolean contains(T t, Node<T> root){
        if (root == null){
            return false;
        }
        int compare = compare(t, root.value);
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
    private Node insert(T t, Node<T> root){
        if (root == null){
            return new Node(t);
        }
        int compare = compare(t, root.value);
        if (compare < 0 ){
            root.left = insert(t, root.left);;
        }else if (compare > 0){
            root.right = insert(t, root.right);;
        }else {
            throw new RuntimeException("there is already a node has value:" + t);
        }
        return root;
    }
    public T findMin(){
        if (root == null){
            return null;
        }else {
            return findMin(root);
        }
    }
    private T findMin(Node root){
        if (root.left != null) {
            return findMin(root.left);
        }else {
            return (T)root.value;
        }
    }
    public T findMax(){
        if (root == null){
            return null;
        }else {
            return findMax(root);
        }
    }
    private T findMax(Node<T> root){
        if (root.right == null){
            return root.value;
        }else {
            return findMax(root.right);
        }
    }
    public void remove(T t){
        root = remove(t, root);
    }
    private Node remove(T t, Node<T> root){
        if (root == null){
            return null;
        }
        int compare = compare(t, root.value);
        if (compare < 0){
            root.left = remove(t, root.left);
            return root;
        }else if (compare > 0){
            root.right = remove(t, root.right);
            return root;
        }else {
            if (root.left == null && root.right == null){
                return null;
            }else if (root.left != null && root.right == null){
                return root.left;
            }else if (root.left == null && root.right != null){
                return root.right;
            }else {
                T value = findMin(root.right);
                root.value = value;
                root.right = remove(value, root.right);
                return root;
            }
        }
    }
    public void print(){
        print(root);
    }
    private void print(Node<T> root){
        if (root != null){
            System.out.print(root.value + " ");
        }
        if (root.left != null){
            print(root.left);
        }
        if (root.right != null){
            print(root.right);
        }
    }
}
