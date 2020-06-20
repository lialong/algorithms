package com.vrddd.adt.stack;

import java.util.Stack;

/**
 * 通过栈来判断字符串中的平衡符号是否是平衡的
 * @author lizelong
 * @date 2020/6/1
 */
public class TestBalanceSymbol {
    private static boolean isBalance(String str){
        Stack<Character> stack = new Stack<>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == '[' || c == '{' || c == '(' ){
                stack.push(c);
            }else if (c == ']'){
                if (stack.isEmpty()){
                    return false;
                }
                Character character = stack.pop();
                if (character == null || character != '['){
                    return false;
                }
            }else if (c == '}'){
                if (stack.isEmpty()){
                    return false;
                }
                Character character = stack.pop();
                if (character == null || character != '{'){
                    return false;
                }
            }else if (c == ')'){
                if (stack.isEmpty()){
                    return false;
                }
                Character character = stack.pop();
                if (character == null || character != '('){
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String str = "{[()]}";
        System.out.println(str + " :" + isBalance(str));
        String str2 = "{[()]}}";
        System.out.println(str2 + " :" + isBalance(str2));
    }
}
