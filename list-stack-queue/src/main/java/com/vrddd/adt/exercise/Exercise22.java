package com.vrddd.adt.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;

/**
 * 计算后缀表达式
 */
public class Exercise22 {
    private static final Stack<Double> stack = new Stack<>();
    private static Map<String, BinaryOperator> operatorMap = new HashMap<>(4);
    private static BinaryOperator<Double> add = (x, y) -> x + y;
    private static BinaryOperator<Double> minus = (x, y) -> x - y;
    private static BinaryOperator<Double> multi = (x, y) -> x * y;
    private static BinaryOperator<Double> divide = (x, y) -> x / y;

    static {
        initOperatorSet();
    }

    private static void initOperatorSet(){
        operatorMap.put("+", add);
        operatorMap.put("-", minus);
        operatorMap.put("*", multi);
        operatorMap.put("/", divide);
    }

    private static Double calSuffix(String[] suffix){
        for (String item: suffix) {
            BinaryOperator<Double> operator = operatorMap.get(item);
            if (operator == null){
                stack.push(Double.valueOf(item));
            }else {
                Double a = stack.pop();
                Double b = stack.pop();
                Double result = operator.apply(a, b);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] expression = "3 8 3 2 + * 5 + + 6 *".split(" ");
        System.out.println(calSuffix(expression));
    }
}
