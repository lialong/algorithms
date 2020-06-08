package com.vrddd.list;

import com.vrddd.adt.list.MyArrayList;
import org.junit.Test;

/**
 * @author lizelong
 * @date 2020/6/2
 */
public class TestMyArrayList {

    @Test
    public void test(){
        MyArrayList<Integer> list = new MyArrayList<>(8);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int size = list.size();
        System.out.println("list 尺寸为：" + size);
        System.out.print("list 包含的元素：");
        for (int i = 0; i < size; i++) {
            System.out.print(list.get(i) + "\t");
        }
        System.out.println("\nlist在移除第三个元素后：");
        list.remove(2);
        System.out.println("list 尺寸为：" + size);
        System.out.print("list 包含的元素：");
        size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.print(list.get(i) + "\t");
        }
    }
}
