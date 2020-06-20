package com.vrddd.adt.exercise;

import com.vrddd.adt.list.MyArrayList;

import java.util.Stack;

/**
 * 检验平衡符号
 */
public class Exercise21 {
    private static final Stack<String> stack = new Stack<>();
    private static final MyArrayList<String> pascalLeftSymbol = new MyArrayList<>(4);
    private static final MyArrayList<String> pascalRightSymbol = new MyArrayList<>(4);
    private static final MyArrayList<String> javaLeftSymbol = new MyArrayList<>(4);
    private static final MyArrayList<String> javaRightSymbol = new MyArrayList<>(4);

    static {
        initPascal();
        initJava();
    }

    private static void initPascal() {
        pascalLeftSymbol.add("begin");
        pascalRightSymbol.add("end");
        pascalLeftSymbol.add("(");
        pascalRightSymbol.add(")");
        pascalLeftSymbol.add("[");
        pascalRightSymbol.add("]");
        pascalLeftSymbol.add("{");
        pascalRightSymbol.add("}");
    }

    private static void initJava() {
        javaLeftSymbol.add("/*");
        javaRightSymbol.add("*/");
        javaLeftSymbol.add("(");
        javaRightSymbol.add(")");
        javaLeftSymbol.add("[");
        javaRightSymbol.add("]");
        javaLeftSymbol.add("{");
        javaRightSymbol.add("}");
    }

    private static boolean check(String[] arr, MyArrayList<String> left, MyArrayList<String> right) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            String str = arr[i];
            int indexLeft = left.get(str);
            if (indexLeft != -1) {
                stack.push(str);
            } else {
                if (stack.empty()){
                    return false;
                }
                String popStr = stack.pop();
                int index = left.get(popStr);
                int indexRight = right.get(str);
                if (index != indexRight) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String[] pascal = {"begin", "(", "[", "{", "}", "]", ")", "end"};
        boolean pascalFlag = check(pascal, pascalLeftSymbol, pascalRightSymbol);
        System.out.println(pascalFlag);
        String[] java = {"/*", "(", "[", "{", "}", "]1", ")", "*/"};
        boolean javaFlag = check(java, javaLeftSymbol, javaRightSymbol);
        System.out.println(javaFlag);

        String[] onlyRight = {"*/"};
        boolean onlyRightFlag = check(onlyRight, javaLeftSymbol, javaRightSymbol);
        System.out.println(onlyRightFlag);
    }
}
