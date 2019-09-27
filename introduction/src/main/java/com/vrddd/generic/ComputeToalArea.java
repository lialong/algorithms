package com.vrddd.generic;

import com.vrddd.generic.entity.Circle;
import com.vrddd.generic.entity.Rectangle;
import com.vrddd.generic.entity.Shape;
import com.vrddd.generic.entity.Square;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ComputeToalArea {

    /**
     * 数组只能是一种类型，Shape[] arr = new Square[2]; arr[0] = new Circle(2d); 运行报错
     * @param shapes
     * @return
     */
    public static double totalArea(Shape[] shapes){
        double area = 0d;
        for (Shape s : shapes) {
            area += s.getArea();
        }
        return area;
    }

    /**
     * 仅能传元素为Shape的集合
     * @param shapes
     * @return
     */
    public static double totalArea(Collection<Shape> shapes){
        double area = 0d;
        for (Shape s: shapes) {
            area += s.getArea();
        }
        return area;
    }

    public static double totalArea2(Collection<? extends Shape> shapes){
        double area = 0d;
        for (Shape s: shapes) {
            area += s.getArea();
        }
        return area;
    }

    public static void main(String[] args) {
        List<Shape> list = new ArrayList<>(3);
        list.add(new Circle(2));
        list.add(new Square(2));
        list.add(new Rectangle(2,3));
        System.out.println(totalArea2(list));
    }

}
