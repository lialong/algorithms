package com.vrddd.adt.exercise;

import com.vrddd.adt.list.MyLinkedList;

/**
 * N个人围起来坐成一个圈，编号1-N，传递一个热土豆，传递M次后，拿着热土豆的人，需要离场，然后下个人拿到土豆再开始传递，知道仅剩一个人为止
 * 若N=5、M=0，则编号1、2、3、4的人依次离场，仅剩编号5
 * 若N=5、M=1，则编号2、4、1、5的人一次离场，仅剩编号3
 */
public class Exercise6 {
    private static Integer lastLeft(Integer N, Integer M){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Integer length = N + 1;
        for (int i = 1; i < length; i++) {
            list.add(i);
        }
        Integer size, index = M;
        while(--N > 0){
            size = list.size();
            if (index < size){
                list.remove(index);
            }else {
                index %= size;
                list.remove(index);
            }
            index += M;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(lastLeft(5, 0));
    }
}
