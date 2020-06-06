package com.vrddd.adt.stack;

import java.util.Stack;

/**
 * 栈计算后缀表达式
 * 操作符：pop两次，运算完成后push
 * 操作数：直接入栈
 *
 * 栈将中缀表达式转为后缀表达式
 * 操作数：直接输出
 * 操作符：入栈前判断，栈中的操作符优先级都是小于它的，也就是说把优先级大于等于它的都pop，最后push
 * 左括号：直接入栈
 * 右括号：不断pop元素，直到把左括号pop出来为止
 *
 * @author lizelong
 * @date 2020/6/1
 */
public class TestExpression {
    /**
     * 计算后缀表达式
     * @param arr
     * @return
     */
    private static double calSuffix(String[] arr){
        Stack<String> stack = new Stack<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            String c = arr[i];
            if ("+".equals(c) || "-".equals(c) || "*".equals(c) || "/".equals(c)){
                double num1 = Double.valueOf(stack.pop());
                double num2 = Double.valueOf(stack.pop());
                double re;
                if ("+".equals(c)){
                    re = num2 + num1;
                }else if ("-".equals(c)){
                    re = num2 - num1;
                }else if ("*".equals(c)){
                    re = num2 * num1;
                }else {
                    re = num2 / num1;
                }
                stack.push(re + "");
            }else {
                stack.push(c);
            }
        }
        return Double.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        String[] expression = "6 5 2 3 + 8 * + 3 + * ".split(" ");
        System.out.println(calSuffix(expression));
        String[] midExpression = "a + b * c + ( d * e + f ) * g".split(" ");
        String[] suffixExpression = midToSuffix(midExpression);
        System.out.println(1);
    }

    /**
     * 将中缀表达式转为后缀表达式
     * @param arr
     * @return
     */
    private static String[] midToSuffix(String[] arr) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            String c = arr[i];
            if ("+".equals(c) || "-".equals(c) || "*".equals(c) || "/".equals(c) || "(".equals(c) || ")".equals(c)) {
                if ("(".equals(c)) {
                    stack.push(c);
                } else if ("+".equals(c) || "-".equals(c)) {
                    if (!stack.isEmpty()) {
                        String top = stack.peek();
                        while (!"(".equals(top)) {
                            stack.pop();
                            sb.append(top + " ");
                            if (stack.isEmpty()) {
                                break;
                            } else {
                                top = stack.peek();
                            }
                        }
                    }
                    stack.push(c);
                } else if ("*".equals(c) || "/".equals(c)) {
                    if (!stack.isEmpty()) {
                        String top = stack.peek();
                        while ("*".equals(top) || "/".equals(top)) {
                            stack.pop();
                            sb.append(top + " ");
                            if (stack.isEmpty()) {
                                break;
                            } else {
                                top = stack.peek();
                            }
                        }
                    }
                    stack.push(c);
                } else if (")".equals(c)) {
                    for (String top = stack.pop(); !"(".equals(top); top = stack.pop()) {
                        sb.append(top + " ");
                    }
                }
            } else {
                sb.append(c + " ");
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        return sb.toString().split(" ");
    }
}
