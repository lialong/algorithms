package com.vrddd.adt.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 后缀表达式转中缀表达式
 * 中缀表达式转后缀表达式
 */
public class Exercise23 {
    private static Stack<String> stack = new Stack<>();
    private static Map<String, Integer> operatorMap = new HashMap<>(4);

    static {
        initOperatorSet();
    }

    private static void initOperatorSet(){
        operatorMap.put("+", 0);
        operatorMap.put("-", 0);
        operatorMap.put("*", 1);
        operatorMap.put("/", 1);
    }

    private static String suffixToMid(String[] suffixArr){
        int length = suffixArr.length;
        for (int i = 0; i < length; i++) {
            String item = suffixArr[i];
            Integer priority = operatorMap.get(item);
            if (priority != null){
                String a = stack.pop();
                String b = stack.pop();
                String union = String.join(" ", "(" , a, item, b, ")");
                stack.push(union);
            }else {
                stack.push(item);
            }
        }
        String expression = stack.pop();
        return expression.substring(1, expression.length() - 1);
    }

    private static String midToSuffix(String[] midArr){
        StringBuilder sb = new StringBuilder();
        for (String item: midArr) {
            if ("(".equals(item)){
                stack.push(item);
            }else if (")".equals(item)){
                while (!stack.peek().equals("(") ){
                    sb.append(stack.pop() + " ");
                }
                stack.pop();
            }else {
                Integer priority = operatorMap.get(item);
                if (priority != null){
                    String top;
                    while (!stack.empty() && !(top = stack.peek()).equals("(") ){
                        if (operatorMap.get(top) >= priority){
                            sb.append(stack.pop() + " ");
                        }else {
                            break;
                        }
                    }
                    stack.push(item);
                }else {
                    sb.append(item +" ");
                }
            }
        }
        while(!stack.empty()){
            sb.append(stack.pop() + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] suffixExpressionArray = "6 5 2 3 + 8 * + 3 + *".split(" ");
        String midExpression = suffixToMid(suffixExpressionArray);
        String[] midExpressionArray = midExpression.split(" ");
        System.out.println(midExpression);
        String result = midToSuffix(midExpressionArray);
        System.out.println(result);
    }
}
