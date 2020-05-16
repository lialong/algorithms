package com.vrddd.avl;

/**
 * 二叉查找树在不断insert和remove后其结构形态发生改变，不再平衡，查询一个节点时复杂度提升
 * 所以在每次插入删除后进行一次平衡算法，保证树的深度不会过深，保证bst的操作性能
 * avl树对平衡的定义是：每个节点的左子树和右子树高度最多相差1
 * 定义空节点的树高度为-1，1个节点的树高度为1
 */
public class AVLTree<T> {
    private AVLNode<T> root;
    private static final int DIFFER = 1;
    private static class AVLNode<T>{
        T value;
        AVLNode<T> left;
        AVLNode<T> right;
        int height;

        AVLNode(T value){
            this.value = value;
        }
    }
    public void insert(T t){
        this.root = insert(t, this.root);
    }
    private int compareTo(T t1, T t2){
        return ((Comparable)t1).compareTo(t2);
    }
    private AVLNode<T> insert(T t, AVLNode<T> root){
        if (root == null){
            return new AVLNode<>(t);
        }
        int compare = compareTo(t, root.value);
        if (compare == 0){

        }else if(compare == -1){
            root.left = insert(t, root.left);
        }else if (compare == 1){
            root.right = insert(t, root.right);
        }
        return balance(root);
    }
    private int height(AVLNode avlNode){
        return avlNode == null ? -1 : avlNode.height;
    }
    private AVLNode<T> balance(AVLNode<T> root){
        if (root == null){
            return null;
        }
        if (height(root.left) - height(root.right) > DIFFER){
            if (height(root.left.left) - height(root.left.right) > DIFFER){
                root = rotateWithLeftChild(root);
            }else {
                root = doubleWithLeftChild(root);
            }
        }else if(height(root.right) - height(root.left) > DIFFER){
            if (height(root.right.right) - height(root.right.left) > DIFFER){
                root = rotateWithRightChild(root);
            }else {
                root = doubleWithRightChild(root);
            }
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return root;
    }
    private AVLNode<T> rotateWithLeftChild(AVLNode<T> k2){
        AVLNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max( height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max( height(k1.left), height(k2)) + 1;
        return k1;
    }
    private AVLNode doubleWithLeftChild(AVLNode<T> k3){
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
    private AVLNode<T> rotateWithRightChild(AVLNode<T> k2){
        AVLNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k2), height(k1.right)) + 1;
        return k1;
    }
    private AVLNode<T> doubleWithRightChild(AVLNode<T> k3){
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }
}
