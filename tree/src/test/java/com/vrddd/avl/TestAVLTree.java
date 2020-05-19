package com.vrddd.avl;

import org.junit.Test;

public class TestAVLTree {
    @Test
    public void test(){
        AVLTree<Integer> avlTree = new AVLTree();
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.print();
    }
}
