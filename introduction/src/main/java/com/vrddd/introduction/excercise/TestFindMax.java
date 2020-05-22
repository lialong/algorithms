package com.vrddd.introduction.excercise;

import com.vrddd.introduction.excercise.entity.Rectangle;
import com.vrddd.introduction.generic.FindMaxDemo2;

import java.util.Comparator;

/**
 * 练习15：找出多个Rectangle中周长、面积最大的
 */
public class TestFindMax {

    static Comparator<Rectangle> compArea = (x,y) -> {
        double b = x.getLength()*x.getWidth() - y.getLength()*y.getWidth();
        if (b == 0){
            return 0;
        }else if (b < 0){
            return -1;
        }else{
            return 1;
        }
    };

    static Comparator<Rectangle> compPerimeter = (x,y) -> {
        double b = x.getLength() + x.getWidth() - y.getLength() - y.getWidth();
        if (b == 0){
            return 0;
        }else if (b < 0){
            return -1;
        }else{
            return 1;
        }
    };

    public static void main(String[] args) {
        Rectangle[] arr = {new Rectangle(12,3),new Rectangle(6,6),new Rectangle(7,8)};
        Rectangle maxArea = FindMaxDemo2.findMax(arr,compArea);
        Rectangle maxPerimeter = FindMaxDemo2.findMax(arr,compPerimeter);
        System.out.println(1);
    }

}
