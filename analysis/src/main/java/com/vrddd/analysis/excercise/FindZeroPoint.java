package com.vrddd.analysis.excercise;

import java.util.function.Function;

/**
 * 练习2.18
 * 找函数零点
 */
public class FindZeroPoint {

    private static Double find(Function<Double,Double> function, double low, double high){
        double mid = (low + high) / 2;
        double lowVal = function.apply(low);
        double highVal = function.apply(high);
        double midVal = function.apply(mid);
        boolean add = lowVal < 0 && highVal > 0;
        boolean sub = lowVal > 0 && highVal < 0;
        if (add || sub){
            if(midVal == 0){
                return mid;
            }else if(midVal < 0){
                if (add){
                    low = mid;
                }else{
                    high = mid;
                }
            }else if (midVal > 0){
                if (add){
                    high = mid;
                }else{
                    low = mid;
                }
            }
            return find(function, low, high);
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        Function<Double,Double> function = x -> x - 1;
        System.out.println(find(function, 0.5, 10));
    }

}
