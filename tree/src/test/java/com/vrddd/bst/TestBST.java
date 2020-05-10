package com.vrddd.bst;

import org.junit.Test;

public class TestBST {
    @Test
    public void testContains(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(12);
        bst.insert(8);
        bst.insert(15);
        bst.insert(16);
        System.out.println(bst.contains(1));
        System.out.println(bst.contains(12));

    }
}
