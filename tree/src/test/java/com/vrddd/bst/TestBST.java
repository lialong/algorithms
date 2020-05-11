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
        bst.insert(14);
        bst.insert(7);
        /*System.out.println("contains 1:" + bst.contains(1));
        System.out.println("contains 12" + bst.contains(12));
        System.out.println("the min:" + bst.findMin());
        System.out.println("the max:" + bst.findMax());*/
        System.out.println("all node:");
        bst.print();

        bst.remove(8);
        System.out.println("\nafter rm 8:");
        bst.print();

        bst.remove(7);
        System.out.println("\nafter rm 7:");
        bst.print();

        bst.remove(15);
        System.out.println("\nafter rm 15:");
        bst.print();
    }
}
