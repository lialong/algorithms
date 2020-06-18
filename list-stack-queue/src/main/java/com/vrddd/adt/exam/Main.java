package com.vrddd.adt.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Comparator<String> getComparator(){
        return (x, y) -> {
            int i=0,j=0;
            int length1 = x.length(), length2 = y.length();
            int compare;
            while (i <length1 && j < length2){
                compare = x.charAt(i) - y.charAt(j);
                if (compare == 0){
                    i++;
                    j++;
                }else if (compare < 0){
                    return -1;
                }else {
                    return 1;
                }
            }
            if (i < length1){
                return getComparator().compare(x.substring(i) + y, x);
            }else if(j < length2){
                return getComparator().reversed().compare(y.indexOf(j) + x, y);
            }else {
                return 0;
            }
        };
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str = in.next();
            List<String> list = Arrays.asList(str.split(","));
            list.sort(getComparator().reversed());
            list.forEach(System.out::print);
        }
    }
}

