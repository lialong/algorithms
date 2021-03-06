package com.vrddd.introduction.generic;

import com.vrddd.introduction.generic.entity.Circle;
import com.vrddd.introduction.generic.entity.Rectangle;
import com.vrddd.introduction.generic.entity.Shape;
import com.vrddd.introduction.generic.entity.Square;

public class FindMaxDemo {

    public static Comparable findArrayMax(Comparable[] arr){
        int maxIndex = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if(arr[i].compareTo(arr[maxIndex]) > 0){
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    public static <T extends Comparable<T>> T findArrayMax2(T[] arr){
        int maxIndex = 0;
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            if(arr[i].compareTo(arr[maxIndex]) > 0){
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    public static void main(String[] args) {
        String[] arr = {"123","321","312"};
        System.out.println(findArrayMax(arr));

        Shape[] arr2 = {new Circle(2), new Square(3), new Rectangle(3,4)};
        System.out.println(findArrayMax(arr2));

        System.out.println(findArrayMax2(arr));

        System.out.println(findArrayMax2(arr2));
    }

}
